import java.util.ArrayList;
import java.util.List;

class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {

        int numberOfDigits = String.valueOf(numberToCheck).length();

        List<Integer> digits = getDigits(numberToCheck);
        int sum = digits.stream()
                        .map(digit -> (int)Math.pow(digit, numberOfDigits))
                        .mapToInt(Integer::intValue)
                        .sum();

        return sum == numberToCheck;

    }

    private List<Integer> getDigits(int number) {
        if (number == 0) {
            return List.of(0);
        }

        List<Integer> digits = new ArrayList<>();

        int n = number;
        while(n > 0) {
            digits.add(n % 10);
            n /= 10;
        }

        return digits;

    }

}
