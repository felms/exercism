import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;

class WordCount {
    public Map<String, Integer> phrase(String input) {
        return new Scanner(input.toLowerCase()).findAll("\\w+('\\w+)?")
                .collect(Collectors.groupingBy(MatchResult::group, Collectors.summingInt(e -> 1)));
    }
}