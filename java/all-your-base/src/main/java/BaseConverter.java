import java.util.ArrayList;
import java.util.List;

class BaseConverter {

    private final int numberBase10;

    BaseConverter(int originalBase, int[] originalDigits) {
        if (originalBase < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }

        this.numberBase10 = convertToBase10(originalBase, originalDigits);
    }

    int[] convertToBase(int newBase) {
        if (newBase < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }

        if (this.numberBase10 == 0) {
            return new int[] { 0 };
        }

        List<Integer> digits = new ArrayList<>();
        int n = this.numberBase10;

        while (n > 0) {
            digits.add(n % newBase);
            n /= newBase;
        }

        return digits.reversed().stream().mapToInt(i -> i).toArray();
    }

    private int convertToBase10(int originalBase, int[] number) {
        int exponent = number.length - 1;
        int sum = 0;

        for (int n : number) {

            if (n < 0) {
                throw new IllegalArgumentException("Digits may not be negative.");
            }

            if (n >= originalBase) {
                throw new IllegalArgumentException("All digits must be strictly less than the base.");
            }

            sum += (int) (n * Math.pow(originalBase, exponent--));
        }

        return sum;
    }
}