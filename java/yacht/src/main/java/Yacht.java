import java.util.Arrays;

class Yacht {

    private final int[] dice;
    private final YachtCategory yachtCategory;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = dice.clone();
        this.yachtCategory = yachtCategory;
    }

    int score() {

        int[] count = {0, 0, 0, 0, 0, 0, 0};

        for (int d : dice) {
            count[d]++;
        }

        int result = 0;
        switch(this.yachtCategory) {
            case ONES:
                result += 1 * count[1];
                break;
            case TWOS:
                result += 2 * count[2];
                break;
            case THREES:
                result += 3 * count[3];
                break;
            case FOURS:
                result += 4 * count[4];
                break;
            case FIVES:
                result += 5 * count[5];
                break;
            case SIXES:
                result += 6 * count[6];
                break;
            case FULL_HOUSE:
                result += calcFullHouse(count);
                break;
            case FOUR_OF_A_KIND:
                result += calcFourOfAKind(count);
                break;
            case LITTLE_STRAIGHT:
                result += (count[1] == 1 && count[2] == 1 && count[3] == 1
                            && count[4] == 1 && count[5] == 1) ? 30 : 0;
                break;
            case BIG_STRAIGHT:
                result += (count[2] == 1 && count[3] == 1 && count[4] == 1
                            && count[5] == 1 && count[6] == 1) ? 30 : 0;
                break;
            case CHOICE:
                result += Arrays.stream(this.dice).sum();
                break;
            case YACHT:
                result += Arrays.stream(count).filter(n -> n == 5).count() > 0 ? 50 : 0;
                break;
                
        }

        return result;
    }

    private int calcFullHouse(int[] dice){

        int result = 0;
        boolean gotTrio = false;
        boolean gotPair = false;
        for (int i = 1; i < dice.length; i++) {
            if (dice[i] == 3) {
                result += 3 * i;
                gotTrio = true;
            } else if (dice[i] == 2) {
                result += 2 * i;
                gotPair = true;
            }
        }

        if (gotPair && gotTrio) {
            return result;
        }

        return 0;
    }

    private int calcFourOfAKind(int[] dice) {
        
        int result = 0;
        for (int i = 1; i < dice.length; i++) {
            if (dice[i] >= 4) {
                result = 4 * i;
                return result;
            }
        }

        return 0;
    }

}
