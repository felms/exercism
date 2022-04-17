class IsbnVerifier {

    boolean isValid(String stringToVerify) {

        char[] digits = stringToVerify.replaceAll("-", "").toCharArray();
        if (digits.length != 10) {
            return false;
        }

        int weight = 10;
        int sum = 0;
        for (char c : digits) {

            if ((c != 'X' && !Character.isDigit(c))
                || (c == 'X' && weight != 1)) {
                return false;
            }

            sum += weight * (c == 'X' ? 10 : Character.getNumericValue(c));
            weight--;
        }

        return sum % 11 == 0;
    }

}
