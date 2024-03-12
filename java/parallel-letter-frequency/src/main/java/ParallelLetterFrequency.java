import java.util.function.Function;
import java.util.stream.Collectors;

import java.util.Map;

class ParallelLetterFrequency {

    private String text;

    ParallelLetterFrequency(String[] texts) {
        this.text = String.join(" ", texts);
    }

    Map<Character, Integer> countLetters() {
        return this.text.codePoints()
            .mapToObj(c -> (char) c)
            .filter(Character::isLetter)
            .map(Character::toLowerCase)
            .collect(Collectors.groupingByConcurrent(
                        Function.identity(),
                        Collectors.summingInt(letter -> 1)));

        // 'letter -> 1' diz à funcão para contar '1'
        // cada vez que a letra aparecer.
        // Caso contrário ele adicionaria o proprio item à soma
        // todas vezes que ele aparecesse.

    }

}
