import java.util.stream.IntStream;

class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        String s = stringToVerify.replaceAll("-", "");
        if (s.length() != 10 || s.matches(".*X.+")) {
            return false;
        }

        StringBuilder sb = new StringBuilder(s).reverse();


        return IntStream.rangeClosed(1, 10)
                    .map(i -> sb.charAt(i - 1) == 'X' ? 10 * i : (sb.charAt(i - 1) - '0') * i)
                    .sum() % 11 == 0;
                            
    }

}
