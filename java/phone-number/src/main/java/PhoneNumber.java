import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PhoneNumber {

    private String number;

    public PhoneNumber(String number) {
        this.number = cleanNumber(number);
    }

    public String getNumber() {
        return this.number;
    }

    private String cleanNumber(String number) {
        String regex = "[\\s+\\.\\(\\)\\-]";
        String n0 = number.replaceAll(regex, "");
        Pattern p;
        Matcher m;

        if (n0.length() < 10) {
            throw new IllegalArgumentException("incorrect number of digits");
        }

        if (n0.length() == 11) {
            if (n0.charAt(0) != '1') {
                throw new IllegalArgumentException("11 digits must start with 1");
            }
            n0 = n0.substring(1);
        }

        if (n0.length() > 11) {
            throw new IllegalArgumentException("more than 11 digits");
        }

        p = Pattern.compile("[a-zA-Z]");
        m = p.matcher(n0);
        if (m.find()) {
            throw new IllegalArgumentException("letters not permitted");
        }

        p = Pattern.compile("[^a-zA-Z0-9]");
        m = p.matcher(n0);
        if (m.find()) {
            throw new IllegalArgumentException("punctuations not permitted");
        }

        if (n0.charAt(0) == '0') {
            throw new IllegalArgumentException("area code cannot start with zero");
        }

        if (n0.charAt(0) == '1') {
            throw new IllegalArgumentException("area code cannot start with one");
        }

        if (n0.charAt(3) == '0') {
            throw new IllegalArgumentException("exchange code cannot start with zero");
        }
        if (n0.charAt(3) == '1') {
            throw new IllegalArgumentException("exchange code cannot start with one");
        }
        
        return n0;
    }
}