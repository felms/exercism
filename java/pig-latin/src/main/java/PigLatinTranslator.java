import java.util.Arrays;
import java.util.stream.Collectors;

class PigLatinTranslator {

    private String regex = "(^[aeiou]|^xr|^y[^aeiou]).*";

    public String translate(String word) {
        return Arrays.stream(word.split(" "))
                .map(this::translateWord).collect(Collectors.joining(" "));
    }

    public String translateWord(String word) {

        if (word.matches(regex)) {
            return word + "ay";
        }

        String newWord = word.matches("^qu.*")
                ? word.substring(2) + "qu" 
                : word.substring(1) + word.substring(0, 1);

        return translateWord(newWord);
    }

}
