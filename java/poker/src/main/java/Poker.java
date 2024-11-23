import java.util.Comparator;
import java.util.List;

class Poker {

    private final List<Hand> hands;

    Poker(List<String> hand) {
        this.hands = hand.stream().map(Hand::new).toList();
    }

    List<String> getBestHands() {
        HandCategory bestHandCategory = this.hands.stream().sorted(Comparator.reverseOrder())
                .toList().getFirst().getHandCategory();

        List<Hand> bestHands = this.hands.stream()
                .filter(hand -> hand.getHandCategory() == bestHandCategory).toList();

        if (bestHands.size() == 1) {
            return List.of(bestHands.getFirst().toString());
        }

        return breakTie(bestHands, bestHandCategory);
    }

    private List<String> breakTie(List<Hand> hands, HandCategory category) {
        return breakTieHighCard(hands, 0);
    }

    private List<String> breakTieOnePair(List<Hand> hands) {
        return null;
    }

    private List<String> breakTieHighCard(List<Hand> hands, int pos) {

        if (pos == 5) {
            return hands.stream().map(Hand::toString).toList();
        }

        int bestCardValue = hands.stream().map(hand -> hand.getCards().get(pos))
                .sorted(Comparator.reverseOrder()).map(Card::getHankValue).toList().getFirst();

        return breakTieHighCard(
                hands.stream().filter(hand -> hand.getCards().get(pos).getHankValue() == bestCardValue).toList(),
                pos + 1);
    }

}