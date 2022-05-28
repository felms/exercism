import java.util.LinkedList;
import java.util.List;

public class BowlingGame {

    private List<Integer> rollList;

    public BowlingGame() {
        this.rollList = new LinkedList<>();
    }

    public void roll(int pins) {

        if (pins < 0) {
            throw new IllegalStateException("Negative roll is invalid");
        }

        if (pins > 10) {
            throw new IllegalStateException("Pin count exceeds pins on the lane");
        }

        if (this.rollList.size() == 20) {
            int throw0 = this.rollList.get(this.rollList.size() - 1);
            if (throw0 < 10 && pins < 10 && throw0 + pins > 10) {
                    throw new IllegalStateException("Pin count exceeds pins on the lane");
                
            }

            int throw1 = this.rollList.get(this.rollList.size() - 2);
            if (throw0 < 10 && throw1 == 10 && pins == 10) {
                throw new IllegalStateException("Pin count exceeds pins on the lane");
            }

            if (throw0 < 10 && throw1 < 10 && throw0 + throw1 < 10) {
                throw new IllegalStateException("Cannot roll after game is over");
            }
            
        }

        if (this.rollList.size() == 21) {
            throw new IllegalStateException("Cannot roll after game is over");
        }

        if (this.rollList.size() > 0 && this.rollList.size() % 2 != 0) {
            int throw0 = this.rollList.get(this.rollList.size() - 1);
            if (throw0 < 10 && pins < 10 && pins + throw0 > 10) {
                throw new IllegalStateException("Pin count exceeds pins on the lane");
            }

        }

        this.rollList.add(pins);
    }

    public int score() {

        if (this.rollList.size() < 12) {
            throw new IllegalStateException("Score cannot be taken until the end of the game");
        }

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

                // Spare
                if (currentScore == 10) {

                    if (this.rollList.isEmpty()) {
                        throw new IllegalStateException("Score cannot be taken until the end of the game");
                    }
                    
                    int throw2 = this.rollList.size() == 1 
                                    ? this.rollList.remove(0) : this.rollList.get(0);
                    totalScore += currentScore + throw2;
                }
            } else { // Strike
                if (this.rollList.size() == 2) {
                    totalScore += throw0;

                    int throwBonus0 = this.rollList.remove(0);
                    int throwBonus1 = this.rollList.remove(0);
                    
                    totalScore += throwBonus0 + throwBonus1;
                } else if (this.rollList.size() > 2){
                    totalScore += throw0 
                                    + this.rollList.get(0) + this.rollList.get(1);
                } else if (this.rollList.size() < 2) {
                    throw new IllegalStateException("Score cannot be taken until the end of the game");
                }
            }
        }

        return totalScore;
        
    }
}