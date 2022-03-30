import java.util.ArrayList;
import java.util.List;

public class Anagram{

    private String word;

    public Anagram(String word) {
        this.word = word;
    }

    public List<String> match(List<String> candidates) {
        List<String> anagrams = new ArrayList<>();

        for ( String str : candidates) {
            String w = word.toLowerCase();
            String str0 = str.toLowerCase();

            if (str0.length() == w.length() && !str0.equals(w)) {
                boolean containsAllLetters = true;
                for (char c : str0.toCharArray()) {                    
                    int index = w.indexOf(c);
                    if (index < 0) {
                        containsAllLetters = false;
                    } else {
                        StringBuilder sb = new StringBuilder(w);
                        sb.deleteCharAt(index);
                        w = sb.toString();
                    }
                    
                }
                if (containsAllLetters) {
                    anagrams.add(str);
                }
            }
            
        }
        
        return anagrams;
        
    }
}