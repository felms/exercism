public class Say {

    public String say(long number) {

        if (number < 0 || number > 999_999_999_999L) {
            throw new IllegalArgumentException();
        }

        String s = "";
        if (number == 0) {
            return "zero";
        }

        s = oneToOneThousand(number);

        long th = number % 1_000_000L;
        th /= 1000;
        if (th > 0) {
            s = oneToOneThousand(th) + " thousand " + s;
        }

        long m = number % 1_000_000_000L;
        m /= 1_000_000;
        if (m > 0) {
            s = oneToOneThousand(m) + " million " + s;
        }

        long b = number % 1_000_000_000_000L;
        b /= 1_000_000_000;
        if (b > 0) {
            s = oneToOneThousand(b) + " billion " + s;
        }

        return s.trim();
    }

    private String oneToOneThousand(long number) {        

        String s = "";

        int u = (int) (number % 10);
        s += units(u);

        int t = (int) (number % 100);

        if (t > 10 && t < 20) {
            s = teens(t);
        } else if (t >= 20) {
            t -= u;
            if (u == 0) {
                s = tens(t);
            } else {
                s = tens(t) + "-" + s;
            }
        }

        int h = (int) (number % 1000);
        h /= 100;
        if (h > 0) {
            s = units(h) + " hundred " + s;
        }

        return s.trim();
    }

    private String units(int number) {
        switch (number) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "";
                
        }
    }

    private String teens(int number) {
        
        switch (number) {
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
                
        }

        return "";
    }

    private String tens(int number) {
        
        switch (number) {
            case 10:
                return "ten";
            case 20:
                return "twenty";
            case 30:
                return "thirty";
            case 40:
                return "forty";
            case 50:
                return "fifty";
            case 60:
                return "sixty";
            case 70:
                return "seventy";
            case 80:
                return "eighty";
            case 90:
                return "ninety";
            default:
                return "";
                
        }
    }
}
