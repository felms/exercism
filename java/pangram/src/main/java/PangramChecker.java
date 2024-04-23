import java.util.Arrays;

public class PangramChecker {

    public boolean isPangram(String input) {
        String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");

        return Arrays.stream(alphabet)
                .allMatch(letter -> input.toLowerCase().contains(letter));

    }

}
