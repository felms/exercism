public class Say {

    public String say(long number) {

        if (number < 0 || number > 999_999_999_999L) {
            throw new IllegalArgumentException();
        }

        if (number == 0) {
            return "zero";
        }

        int b = (int) (number / 1_000_000_000);
        int m = (int) (number % 1_000_000_000) / 1_000_000;
        int t = (int) (number % 1_000_000);
        String res = billions(b);
        res += m > 0 ? " " + millions(m) : "";
        res += t > 0 ? " " + thousands(t) : "";

        return res.trim();
    }

    private String billions(int number) {
        return number > 0 ? hundreds(number) + " billion" : "";
    }

    private String millions(int number) {
        return number > 0 ? hundreds(number) + " million" : "";
    }

    private String thousands(int number) {
        int tn = number / 1000;
        return (tn > 0 ? hundreds(tn) + " thousand" : "")
                + ((tn > 0 && number % 1000 > 0) ? " " : "")
                + ((number % 1000 > 0) ? hundreds(number % 1000) : "");
    }

    private String hundreds(int number) {
        int n = number / 100;
        String t = number % 100 != 0 ? " " + tens(number % 100) : "";
        return n == 0 ? tens(number) : units(n) + " hundred" + t;
    }

    private String tens(int number) {
        int n = number / 10;
        String u = number % 10 != 0 ? "-" + units(number % 10) : "";
        return switch (n) {
            case 1 -> teens(number);
            case 2 -> "twenty" + u;
            case 3 -> "thirty" + u;
            case 4 -> "forty" + u;
            case 5 -> "fifty" + u;
            case 6 -> "sixty" + u;
            case 7 -> "seventy" + u;
            case 8 -> "eighty" + u;
            case 9 -> "ninety" + u;
            default -> units(number);
        };
    }

    private String teens(int number) {
        return switch (number) {
            case 10 -> "ten";
            case 11 -> "eleven";
            case 12 -> "twelve";
            case 13 -> "thirteen";
            case 14 -> "fourteen";
            case 15 -> "fifteen";
            case 16 -> "sixteen";
            case 17 -> "seventeen";
            case 18 -> "eighteen";
            case 19 -> "nineteen";
            default -> "";
        };
    }

    private String units(int number) {
        return switch (number) {
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            default -> "";
        };
    }
}
