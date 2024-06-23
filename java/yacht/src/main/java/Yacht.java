import java.util.Arrays;
import java.util.List;

class Yacht {

    private int[] dice;
    private YachtCategory yachtCategory;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = Arrays.copyOf(dice, dice.length);
        this.yachtCategory = yachtCategory;
    }

    int score() {
        return switch(yachtCategory) {
            case YACHT -> scoreYacht();
            case ONES -> scoreNumberCategory(1);
            case TWOS -> scoreNumberCategory(2);
            case THREES -> scoreNumberCategory(3);
            case FOURS -> scoreNumberCategory(4);
            case FIVES -> scoreNumberCategory(5);
            case SIXES -> scoreNumberCategory(6);
            case FULL_HOUSE -> scoreFullHouse();
            case FOUR_OF_A_KIND -> scoreFourOfAKind();
            case LITTLE_STRAIGHT -> scoreStraight(List.of(1, 2, 3, 4, 5));
            case BIG_STRAIGHT -> scoreStraight(List.of(2, 3, 4, 5, 6));
            case CHOICE -> Arrays.stream(dice).sum();
            default -> 0;
        };
    }

    private int scoreYacht() {
        return Arrays.stream(dice).distinct().count() == 1 ? 50 : 0;
    }

    private int scoreNumberCategory(int number) {
        return numberFreq(dice, number) * number;
    }

    private int scoreFullHouse() {
        return Arrays.stream(dice).anyMatch(number -> numberFreq(dice, number) == 3)
                && Arrays.stream(dice).anyMatch(number -> numberFreq(dice, number) == 2)
                ? Arrays.stream(dice).sum() : 0;

    }
    private int scoreFourOfAKind() {
        return Arrays.stream(dice)
                .filter(number -> numberFreq(dice, number) >= 4)
                .findFirst().orElse(0) * 4;
    }

    private int scoreStraight(List<Integer> straight) {
        List<Integer> diceList = Arrays.stream(dice).boxed().toList();
        return straight.stream()
               .allMatch(number -> diceList.contains(number)) ? 30 : 0;
    }

    private int numberFreq(int[] array, int number) {
        return (int) Arrays.stream(array).filter(n -> n == number).count();
    }
}
