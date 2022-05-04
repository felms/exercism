import java.util.Arrays;

class LargestSeriesProductCalculator {

    private final String number;

    LargestSeriesProductCalculator(String inputNumber) {
        if (inputNumber.matches(".*[^\\d].*")) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
        this.number = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {

        if (numberOfDigits > this.number.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }

        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }

        if (this.number.length() < 1 || numberOfDigits == 0) {
            return 1;
        }

        long largestProduct = Long.MIN_VALUE;
        for (int i = 0; i <= number.length() - numberOfDigits; i++) {
            String subs = this.number.substring(i, i + numberOfDigits);
            long product = Arrays.stream(subs.split(""))
                    .mapToLong(Long::parseLong)
                    .reduce(1, (a, b) -> a * b);
            largestProduct = Math.max(largestProduct, product);
        }

        return largestProduct;
    
    }
}
