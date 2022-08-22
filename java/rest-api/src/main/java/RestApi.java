import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestApi{

    private final List<User> userList;

    public RestApi(User ...users) {
        this.userList = new ArrayList<>();
        this.userList.addAll(List.of(users));
    }

    public String get(String url, JSONObject ...payload) {

        JSONObject jsonObject = new JSONObject();

        if (payload.length > 0) {
            String name = ((JSONArray)payload[0].get("users")).getString(0);
            User searchedUser = this.userList.stream()
                    .filter(user -> user.name().equals(name))
                    .collect(Collectors.toList()).get(0);

            JSONArray jsonArray = new JSONArray();
            jsonArray.put(userToJSON(searchedUser));
            jsonObject.put("users", jsonArray);

        } else {
            jsonObject.put("users", this.userList);
        }

        System.out.println(jsonObject);

        return jsonObject.toString();
    }

    public String post(String url, JSONObject payload) {

        if (url.equals("/add")) {
            String name = (String) payload.get("user");

            User.Builder builder = User.builder();
            builder.setName(name);
            User user = builder.build();

            this.userList.add(user);
            return userToJSON(user).toString();
        }

        if (url.equals("/iou")) {
           return addIou(payload);
        }
        return null;
    }

    private String addIou(JSONObject payload) {
        String lenderName = (String) payload.get("lender");
        String borrowerName = (String) payload.get("borrower");
        double amount = (double) payload.get("amount");
        JSONArray jsonArray = new JSONArray();

        boolean usersAlreadyInDB = this.userList.stream()
                .anyMatch(user -> user.name().equals(lenderName));


        if (usersAlreadyInDB) {
            for (int i = 0; i < this.userList.size(); i++) {
                User currentUser = this.userList.get(i);
               if (currentUser.name().equals(lenderName)) {
                   List<Iou> owes = new ArrayList<>(currentUser.owes());
                   List<Iou> owedBy = new ArrayList<>(currentUser.owedBy());
                   User.Builder builder = User.builder();
                   builder.setName(lenderName);
                   owes.forEach(iou -> builder.owes(iou.name, iou.amount));
                   owedBy.forEach(iou -> builder.owedBy(iou.name, iou.amount));
                   builder.owedBy(borrowerName, amount);
                   User lender = builder.build();
                   this.userList.remove(i);
                   this.userList.add(i, lender);
                   jsonArray.put(userToJSON(lender));
                   System.out.println("Lender added: " + jsonArray);
               } else if (currentUser.name().equals(borrowerName)) {
                   List<Iou> owes = new ArrayList<>(currentUser.owes());
                   List<Iou> owedBy = new ArrayList<>(currentUser.owedBy());
                   User.Builder builder = User.builder();
                   builder.setName(borrowerName);
                   owes.forEach(iou -> builder.owes(iou.name, iou.amount));
                   owedBy.forEach(iou -> builder.owedBy(iou.name, iou.amount));
                   builder.owes(lenderName, amount);
                   User borrower = builder.build();
                   this.userList.remove(i);
                   this.userList.add(i, borrower);
                   jsonArray.put(userToJSON(borrower));
               }
            }

        } else {
            System.out.println("Aqui||");
            User.Builder builder = User.builder();
            builder.setName(lenderName);
            builder.owedBy(borrowerName, amount);
            User lender = builder.build();

            builder = User.builder();
            builder.setName(borrowerName);
            builder.owes(lenderName, amount);
            User borrower = builder.build();

            this.userList.add(lender);
            this.userList.add(borrower);
            jsonArray.put(userToJSON(lender));
            jsonArray.put(userToJSON(borrower));
        }

        JSONObject jo = new JSONObject()
                .put("users", jsonArray);

        System.out.println(jo);

        return jo.toString();
    }

    private JSONObject userToJSON(User user) {
        String n = user.name();
        List<Iou> o = user.owes();
        List<Iou> oBy = user.owedBy();
        double balance = oBy.stream().map(iou -> iou.amount)
                .mapToDouble(Double::doubleValue).sum() -
                o.stream().map(iou -> iou.amount)
                        .mapToDouble(Double::doubleValue).sum();

        JSONObject owes = new JSONObject();
        o.forEach(iou -> owes.put(iou.name, iou.amount));

        JSONObject owedBy = new JSONObject();
        oBy.forEach(iou -> owedBy.put(iou.name, iou.amount));

        return new JSONObject()
                .put("name", n)
                .put("owes", owes)
                .put("owedBy", owedBy)
                .put("balance", balance);
    }
}