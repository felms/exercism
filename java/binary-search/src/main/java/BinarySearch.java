import java.util.ArrayList;
import java.util.List;

class BinarySearch {

    private List<Integer> items;

    BinarySearch(List<Integer> items) {
        this.items = new ArrayList<>(items);
    }

    int indexOf(int item) throws ValueNotFoundException {

        int start = 0;
        int end = this.items.size() - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            int middleItem = this.items.get(middle);

            if (middleItem == item) {
                return middle;
            } 

            if (middleItem > item) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }

        }

        throw new ValueNotFoundException("Value not in array");

    }
}
