import java.util.List;
import java.util.stream.IntStream;

class Series {

    private String number;

    Series(String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException("series cannot be empty");
        }

        this.number = string;
    }

    List<String> slices(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("slice length cannot be negative or zero");
        }

        if (num > this.number.length()) {
            throw new IllegalArgumentException("slice length cannot be greater than series length");
        }

        return IntStream.range(0, this.number.length() - num + 1)
                .mapToObj(pos -> this.number.substring(pos, pos + num))
                .toList();
    }
}
