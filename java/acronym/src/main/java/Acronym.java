import java.util.Arrays;
import java.util.stream.Collectors;

class Acronym {

    private String acronym;

    Acronym(String phrase) {

        this.acronym = Arrays.stream(phrase.replaceAll("-|_", " ").split("\\s+"))
                .map(word -> word.toUpperCase().substring(0, 1))
                .collect(Collectors.joining());
    }

    String get() {
        return this.acronym;
    }

}
