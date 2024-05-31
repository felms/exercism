import java.util.Comparator;
import java.util.List;

class HighScores {

    private final List<Integer> scores;

    public HighScores(List<Integer> highScores) {
        this.scores = highScores;
    }

    List<Integer> scores() {
        return this.scores;
    }

    Integer latest() {
        return this.scores.getLast();
    }

    Integer personalBest() {
        return this.scores.stream().max(Integer::compareTo).orElseThrow();
    }

    List<Integer> personalTopThree() {
        return this.scores.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
    }

}
