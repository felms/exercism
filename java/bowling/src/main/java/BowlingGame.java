import java.util.LinkedList;
import java.util.List;

public class BowlingGame {

    private List<Integer> rollList;

    public BowlingGame() {
        this.rollList = new LinkedList<>();
    }

    public void roll(int pins) {
        this.rollList.add(pins);
    }

    public int score() {

        int totalScore = 0;

        while(!this.rollList.isEmpty()) {
            int throw0 = this.rollList.remove(0);

            
            if (throw0 < 10) {
                int throw1 = this.rollList.remove(0);
                int currentScore = throw0 + throw1;

                // Open frame
                if (currentScore < 10) {
                    totalScore += currentScore;
                }
            }
        }

        return totalScore;
        
    }
}