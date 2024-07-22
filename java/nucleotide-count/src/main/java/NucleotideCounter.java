import java.util.function.Function;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class NucleotideCounter {

    private Map<Character, Integer> counts;

    NucleotideCounter(String sequence) {
        if (sequence.matches(".*[^ACGT]+.*")) {
            throw new IllegalArgumentException();
        }

        this.counts = new HashMap<>();

        var list = sequence.chars().mapToObj(i -> (char)i).toList();
        "ACGT".chars().mapToObj(i -> (char)i)
            .forEach(item -> this.counts.put(item, Collections.frequency(list, item)));
    }

    Map<Character, Integer> nucleotideCounts() {
        return this.counts;
    }

}
