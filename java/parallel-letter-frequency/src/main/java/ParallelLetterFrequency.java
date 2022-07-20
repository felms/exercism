import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParallelLetterFrequency{

    private final String text;

    public ParallelLetterFrequency(String text) {
        this.text = text;
    }

    public Map<Integer, Integer> letterCounts() {

        List<Character> processedInput = this.text
                .chars()
                .map(Character::toLowerCase)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        Set<Character> uniqueLetters = this.text
                .chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());


        return uniqueLetters.stream()
                .collect(Collectors.toMap(letterKey -> (int) letterKey,
                        letterValue -> Collections.frequency(processedInput, letterValue)));
    }
}