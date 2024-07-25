import java.util.Arrays;
import java.util.List;

class Anagram {

    private String word;

    public Anagram(String word) {
        this.word = word.toLowerCase();
    }

    public List<String> match(List<String> candidates) {
        return candidates.stream().filter(this::isAnagram).toList();
    }

    private boolean isAnagram(String candidate) {
        return !candidate.toLowerCase().equals(this.word) 
                    && Arrays.equals(
                            candidate.toLowerCase().chars().sorted().toArray(),
                            this.word.chars().sorted().toArray()
                        );
    }
}
