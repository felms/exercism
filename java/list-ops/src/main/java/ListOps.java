import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

class ListOps {

    static <T> List<T> append(List<T> list1, List<T> list2) {

        List<T> l1 = new ArrayList<>(list1);
        l1.addAll(list2);
        
        return l1;
        
    }

    static <T> List<T> concat(List<List<T>> listOfLists) {

        List<T> res = new ArrayList<>();

        for (List<T> l : listOfLists) {
            res.addAll(l);
        }

        return res;
    }

    static <T> List<T> filter(List<T> list, Predicate<T> predicate) {

        List<T> res = new ArrayList<>();

        for (T item : list) {
            if (predicate.test(item)) {
                res.add(item);
            }
        }

        return res;
    }

    static <T> int size(List<T> list) {

        int s = 0;

        for (T item : list) {
            s++;
        }

        return s;
    }

    static <T, U> List<U> map(List<T> list, Function<T, U> transform) {

        List<U> res = new ArrayList<>();

        for (T item : list) {
            res.add(transform.apply(item));
        }

        return res;
    }

    static <T> List<T> reverse(List<T> list) {

        List<T> res = new ArrayList<>();
        int s = size(list);

        for (int i = s - 1; i >= 0; i--) {
            res.add(list.get(i));
        }

        return res;
    }

    static <T, U> U foldLeft(List<T> list, U initial, BiFunction<U, T, U> f) {
        U acc = initial;

        for (T item : list) {
            acc = f.apply(acc, item);
        }

        return acc;
    }

    static <T, U> U foldRight(List<T> list, U initial, BiFunction<T, U, U> f) {

        U acc = initial;

        for (T item : reverse(list)) {
            acc = f.apply(item, acc);
        }

        return acc;
    }

    private ListOps() {
        // No instances.
    }

}
