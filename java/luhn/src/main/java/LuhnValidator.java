import java.util.Arrays;

class LuhnValidator {

    public static boolean isValid(String candidate) {

        String input = candidate.trim();

        if (input.matches(".*[^\\d\\s].*") || input.length() < 2) {
            return false;
        }

        input = input.replaceAll("\\s+", "");
        int[] numbers = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();

        for (int i = numbers.length - 2; i >= 0 ; i -= 2) {
            int digit = numbers[i] * 2;
            numbers[i] = digit > 9 ? digit - 9 : digit;
        }

        return Arrays.stream(numbers).sum() % 10 == 0;

    }

}
