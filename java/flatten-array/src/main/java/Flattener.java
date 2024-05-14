import java.util.ArrayList;
import java.util.List;

class Flattener {

    <T> List<T> flatten(List<T> list) {

        List<T> res;

        if (list.isEmpty()) {
            res = new ArrayList<>();
            return res;
        }

        T item = list.get(0);

        if (item instanceof List) {
            res = flatten((List)item);
        } else {
            res = new ArrayList<>();
            if (item != null) {
                res.add(item);
            }
        }

        res.addAll(flatten(list.subList(1, list.size())));
        return res;

    }

}
