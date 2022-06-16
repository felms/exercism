import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomSet<T> {

    private int size;
    private final List<T> setItems;
    public CustomSet() {
        this(new ArrayList<>());
    }

    public CustomSet(List<T> items) {
        this.size = 0;
        this.setItems = new ArrayList<>();

        items.forEach(item -> {
            if (!this.setItems.contains(item)) {
                this.setItems.add(item);
                this.size++;
            }
        });
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(T item) {
        return this.setItems.contains(item);
    }

    public boolean add(T item) {
        if (!this.setItems.contains(item)) {
            this.setItems.add(item);
            this.size++;
            System.out.println(this.toString());
            return true;
        }

        return false;
    }

    public List<T> getValues() {
        return new ArrayList<>(this.setItems);
    }

    public boolean isSubset(CustomSet<T> other) {

        if (other.isEmpty()) {
            return true;
        }

        boolean containsAll = true;
        for (T item : other.getValues()){
            containsAll = containsAll && this.setItems.contains(item);
        }

        return containsAll;
    }

    public CustomSet<T>  getIntersection(CustomSet<T> other) {
        List<T> allItems = new ArrayList<>(this.getValues());
        allItems.addAll(other.getValues());

        CustomSet<T> intersection = new CustomSet<>();
        for (T item : allItems) {
            if (this.contains(item) && other.contains(item)) {
                intersection.add(item);
            }
        }

        return intersection;
    }

    public boolean isDisjoint(CustomSet<T> other) {
        return this.getIntersection(other).isEmpty();
    }

    public CustomSet<T> getDifference(CustomSet<T> other) {
        CustomSet<T> difference = new CustomSet<>();

        for (T item : this.getValues()) {
            if (!other.contains(item)) {
                difference.add(item);
            }
        }

        return difference;
    }

    public CustomSet<T> getUnion(CustomSet<T> other) {
        List<T> allItems = new ArrayList<>(this.getValues());
        allItems.addAll(other.getValues());

        return new CustomSet<>(allItems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomSet<T> other = (CustomSet<T>) o;
        if (this.size != other.size) {
            return false;
        }

        return this.isSubset(other) && other.isSubset(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, setItems);
    }

    @Override
    public String toString() {
        return "CustomSet{" +
                "size=" + size +
                ", setItems=" + setItems +
                '}';
    }
}