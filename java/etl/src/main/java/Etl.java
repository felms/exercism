import java.util.List;
import java.util.HashMap;
import java.util.Map;

class Etl {
    Map<String, Integer> transform(Map<Integer, List<String>> old) {
        
        Map<String, Integer> newScore = new HashMap<>();
        old.forEach((key, value) -> value.forEach(letter -> newScore.put(letter.toLowerCase(), key)));
        return newScore;
    }
}
