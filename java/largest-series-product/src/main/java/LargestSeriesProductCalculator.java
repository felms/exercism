import java.util.Arrays;
import java.util.stream.IntStream;

class LargestSeriesProductCalculator {

    private String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        if (inputNumber.matches(".*\\D.*")) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }

        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }

        if (numberOfDigits > this.inputNumber.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }

        return IntStream.range(0, (this.inputNumber.length() - numberOfDigits + 1))
            .mapToObj(pos -> this.inputNumber.substring(pos, pos + numberOfDigits))
            .mapToLong(this::product).max().getAsLong();

    }

    private long product(String inputNumber) {
        return Arrays.stream(inputNumber.split(""))
                .mapToLong(Integer::parseInt)
                .reduce((a, b) -> a * b).getAsLong();
    }
}
