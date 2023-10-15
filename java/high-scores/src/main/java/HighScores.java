import java.util.List;

class HighScores {

    private final List<Integer> scoresList;
    public HighScores(List<Integer> highScores) {
        this.scoresList = highScores;
    }

    List<Integer> scores() {
        return this.scoresList;
    }

    Integer latest() {
        return this.scoresList.get(this.scoresList.size() - 1);
    }

    Integer personalBest() {
        return this.scoresList.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    List<Integer> personalTopThree() {
        return this.scoresList.stream()
                .sorted((a, b) -> b - a)
                .limit(3)
                .toList();
    }

}
