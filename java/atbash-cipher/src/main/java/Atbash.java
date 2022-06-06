import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Atbash {

    private final List<String> plain;
    private final List<String> cipher;

    public Atbash() {
        this.plain = Arrays.asList("abcdefghijklmnopqrstuvwxyz0123456789".split(""));
        this.cipher = Arrays.asList("zyxwvutsrqponmlkjihgfedcba0123456789".split(""));
    }

    public String encode(String string) {

        String s = Arrays.asList(string.toLowerCase().split("")).stream()
                                .map(letter -> {
                                    int pos = plain.indexOf(letter);
                                    return pos >= 0 ? cipher.get(pos) : "";
                                }).collect(Collectors.joining());
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i += 5) {
            int end = i + 5;
            if (end < s.length()) {
                sb.append(s.substring(i, end)).append(" ");
            } else {
                sb.append(s.substring(i));
            }

        }
        
        return sb.toString();
    }

    public String decode(String string) {
        return Arrays.asList(string.toLowerCase().split("")).stream()
                    .map(letter -> {
                        int pos = cipher.indexOf(letter);
                        return pos >= 0 ? plain.get(pos) : "";
                    }).collect(Collectors.joining());
    }

}