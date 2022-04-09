import java.util.Map;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WordCount{

   
    public Map<String, Integer> phrase(String input) {
        Map<String, Integer> wordCount = new HashMap<>();

        List<String> words = Arrays.asList(getWords(input));
        words.forEach(word -> wordCount.putIfAbsent(word, Collections.frequency(words, word)));

        return wordCount;
    }

    private String[] getWords(String input) {
        
        String[] w = input.toLowerCase().replaceAll("[,:;]", " ").trim().split("\\s+");

        for (int i = 0; i < w.length; i++) {
            w[i] = w[i].replaceAll("^['\"]|[\\.\\?!:]|[^a-z0-9']", "");
            w[i] = w[i].replaceAll("['\"]$", "");
            w[i] = w[i].replaceAll("['\"]$", "");
        }
        
        return w;
    }

}

