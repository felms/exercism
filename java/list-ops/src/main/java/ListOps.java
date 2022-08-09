import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

class ListOps {

    static <T> List<T> append(List<T> list1, List<T> list2) {

        List<T> newList = new ArrayList<>();
        newList.addAll(list1);
        newList.addAll(list2);
        return newList;
    }

    static <T> List<T> concat(List<List<T>> listOfLists) {

        List<T> newList = new ArrayList<>();

        for (List<T> list : listOfLists) {
            newList.addAll(list);
        }

        return newList;
    }

    static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();

        for (T item : list) {
            if (predicate.test(item)) {
                newList.add(item);
            }
        }

        return newList;
    }

    static <T> int size(List<T> list) {
        return list.size();
    }

    static <T, U> List<U> map(List<T> list, Function<T, U> transform) {
        List<U> newList = new ArrayList<>();

        for (T item : list) {
            newList.add(transform.apply(item));
        }

        return newList;
    }

    static <T> List<T> reverse(List<T> list) {
        List<T> newList = new ArrayList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            newList.add(list.get(i));
        }

        return newList;
    }

    static <T, U> U foldLeft(List<T> list, U initial, BiFunction<U, T, U> f) {
        U result = initial;

        for (T item : list) {
            result = f.apply(result, item);
        }

        return result;
    }

    static <T, U> U foldRight(List<T> list, U initial, BiFunction<T, U, U> f) {
        U result = initial;

        for (int i = list.size() - 1; i >= 0; i--) {
            result = f.apply(list.get(i), result);
        }

        return result;
    }

    private ListOps() {
        // No instances.
    }
}
