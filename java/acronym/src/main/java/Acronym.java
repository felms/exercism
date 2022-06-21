import java.util.Arrays;
import java.util.stream.Collectors;

class Acronym {

    private final String phrase;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        return Arrays.asList(this.phrase.split("\\s+"))
                        .stream()
                        .map(word -> word.toUpperCase().substring(0, 1))
                        .collect(Collectors.joining());

    }

}
