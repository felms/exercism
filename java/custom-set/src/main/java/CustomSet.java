import java.util.Collection;

import java.util.ArrayList;
import java.util.List;

class CustomSet<T> {

    private List<T> items;

    CustomSet() {
        this.items = new ArrayList<>();
    }

    CustomSet(Collection<T> data) {
        this();
        data.forEach(this::add);
    }

    boolean isEmpty() {
        return this.items.size() == 0;
    }

    boolean contains(T element) {
        return this.items.contains(element);
    }

    boolean isDisjoint(CustomSet<T> other) {
        return this.items.stream().noneMatch(other::contains);
    }

    boolean add(T element) {
        if (!this.contains(element)) {
            return this.items.add(element);
        }

        return false;
    }

    @Override
    public boolean equals(Object obj) {
        CustomSet<T> other = (CustomSet<T>) obj;

        return other.items.size() == this.items.size()
                && other.items.stream().allMatch(this::contains);
    }

    CustomSet<T> getIntersection(CustomSet<T> other) {
        List<T> data = this.items.stream().filter(other::contains).toList();
        return new CustomSet<T>(data);
    }

    CustomSet<T> getUnion(CustomSet<T> other) {
        CustomSet<T> res = new CustomSet<>(new ArrayList<>(this.items));
        other.items.forEach(res::add);
        
        return res;
    }

    CustomSet<T> getDifference(CustomSet<T> other) {
        List<T> data = this.items.stream().filter(item -> !other.contains(item)).toList();
        return new CustomSet<T>(data);
    }

    boolean isSubset(CustomSet<T> other) {
        if (other.isEmpty()) {
            return true;
        }

        return other.items.stream().allMatch(this::contains);
    }
}
