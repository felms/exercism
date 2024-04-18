class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        int numberOfDigits = 1 + (int)Math.log10(numberToCheck);

        int n = numberToCheck;
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, numberOfDigits);
            n /= 10;
        }

        return sum == numberToCheck;
    }

}
