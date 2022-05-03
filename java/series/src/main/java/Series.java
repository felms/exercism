import java.util.ArrayList;
import java.util.List;

public class Series{

    private final String number;

    public Series(String number) {
        this.number = number;
    }

    public List<String> slices(int size) {

        if (size > this.number.length()) {
            throw new IllegalArgumentException("Slice size is too big.");
        }

        if (size < 1) {
            throw new IllegalArgumentException("Slice size is too small.");
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i <= number.length() - size; i++) {
            list.add(this.number.substring(i, i + size));
        }

        return list;
    }
}