import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParallelLetterFrequency{

    private final String text;

    public ParallelLetterFrequency(String text) {
        this.text = text;
    }

    public Map<Integer, Integer> letterCounts() {

        return this.text.chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .boxed()
                .collect(Collectors.groupingByConcurrent(
                        Function.identity(),
                        Collectors.summingInt(letter -> 1)));
        // 'letter -> 1' diz à funcão para contar '1'
        // cada vez que a letra aparecer.
        // Caso contrário ele adicionaria o proprio item à soma
        // todas vezes que ele aparecesse.
    }
}