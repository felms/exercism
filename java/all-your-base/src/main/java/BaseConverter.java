import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseConverter {

    private int numberInBaseTen;

    public BaseConverter(int base, int[] number) {

        if (base < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }

        this.numberInBaseTen = 0;

        int exponent = 0;
        for (int i = number.length - 1; i >= 0; i--) {
            if (number[i] < 0) {
                throw new IllegalArgumentException("Digits may not be negative.");
            }

            if (number[i] >= base) {
                throw new IllegalArgumentException("All digits must be strictly less than the base.");
            }

            numberInBaseTen += number[i] * Math.pow(base, exponent);
            exponent++;
        }
    }

    public int[] convertToBase(int newBase) {

        if (newBase < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }

        List<Integer> digits = new ArrayList<>();

        if (this.numberInBaseTen == 0) {
            return new int[]{0};
        }

        int n = this.numberInBaseTen;
        while (n > 0) {
            digits.add(n % newBase);
            n /= newBase;
        }
        Collections.reverse(digits);

        return digits.stream().mapToInt(Integer::intValue).toArray();
    }
}