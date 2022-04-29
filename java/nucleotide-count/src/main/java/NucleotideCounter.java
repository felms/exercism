import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.swing.event.CaretListener;

public class NucleotideCounter {

    private final String nucleotides;

    public NucleotideCounter(String nucleotides) {
        if (!"".equals(nucleotides) && !nucleotides.matches("\\b[ACGT]+\\b")) {
            throw new IllegalArgumentException();
        }
        
        this.nucleotides = nucleotides;
    }

    public Map<Character, Integer> nucleotideCounts() {

        Map<Character, Integer> map = "ACGT".chars()
                                            .mapToObj(c -> (char) c)
                                            .collect(Collectors.toMap(Function.identity(), i -> 0));
        
        List<Character> list = Arrays.asList(this.nucleotides.chars().mapToObj(c -> (char)c).toArray(Character[]::new));
        list.forEach(item -> map.put(item, Collections.frequency(list, item)));
        return map;
    }
}

