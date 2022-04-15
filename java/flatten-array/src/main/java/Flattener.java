import java.util.ArrayList;
import java.util.List;

public class Flattener {


    public List<Object> flatten(List<Object> inputList) {
        List<Object> list = new ArrayList<>();
        Object o = inputList.get(0);
        if (!(o instanceof List)) {
            if (o != null) {                
                list.add(o);
            }
            if (inputList.size() > 1) {                
                list.addAll(flatten(inputList.subList(1, inputList.size())));
            }
        } else {
            List<Object> l0 = (List<Object>) o;
            list.addAll(flatten(l0));
            if (inputList.size() > 1) {                
                list.addAll(flatten(inputList.subList(1, inputList.size())));
            }
        }

        return list;
    }
}