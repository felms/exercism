import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public  class Hand implements Comparable<Hand>{

    private final List<Card> cards;
    private final HandCategory handCategory;

    public Hand(String handString) {
        this.cards = Arrays.stream(handString.split("\\s+")).map(Card::new).toList();
        this.handCategory = Hand.categorizeHand(this.cards);
    }

    public List<Card> getCards() {
        return this.cards.stream().sorted(Comparator.reverseOrder()).toList();
    }

    HandCategory getHandCategory() {
        return this.handCategory;
    }

    static HandCategory categorizeHand(List<Card> cards) {

        List<Integer> sortedRanks = cards.stream().map(Card::getHankValue).sorted(Comparator.reverseOrder()).toList();

        boolean isStraight = sortedRanks.getFirst() - sortedRanks.getLast() == 4
                || (sortedRanks.getFirst() == 14 && (sortedRanks.get(1) - sortedRanks.getLast() == 3));

        boolean isFlush = cards.stream().map(Card::getSuit).distinct().count() == 1;

        String freq = cards.stream().map(Card::getHankValue)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream().sorted(Comparator.reverseOrder())
                .map(Object::toString).collect(Collectors.joining());

        if (isStraight && isFlush) {
            return HandCategory.STRAIGHT_FLUSH;
        }

        if (freq.equals("41")) {
            return HandCategory.FOUR_OF_A_KIND;
        }

        if (freq.equals("32")) {
            return HandCategory.FULL_HOUSE;
        }

        if (isFlush) {
            return HandCategory.FLUSH;
        }

        if (isStraight) {
            return HandCategory.STRAIGHT;
        }

        return switch (freq) {
            case "311" -> HandCategory.THREE_OF_A_KIND;
            case "221" -> HandCategory.TWO_PAIR;
            case "2111" -> HandCategory.ONE_PAIR;
            default -> HandCategory.HIGH_CARD;
        };

    }

    @Override
    public int compareTo(Hand o) {
        return this.handCategory.getValue() - o.handCategory.getValue();
    }

    @Override
    public String toString() {
        return this.cards.stream().map(Card::toString).collect(Collectors.joining(" "));
    }
}

enum HandCategory {

    HIGH_CARD(0), ONE_PAIR(1), TWO_PAIR(2), THREE_OF_A_KIND(3), STRAIGHT(4),
    FLUSH(5), FULL_HOUSE(6), FOUR_OF_A_KIND(7), STRAIGHT_FLUSH(8);

    private final int value;

    HandCategory(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
