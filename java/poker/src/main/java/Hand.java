import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class Hand implements Comparable<Hand>{

    private final List<Card> hand;
    private final HandRankingCategorie categorie;

    public Hand(String inputHand) {
        String[] cards = inputHand.split("\\s+");
        hand = new ArrayList<>();
        Arrays.stream(cards).forEach(card -> hand.add(new Card(card)));
        this.categorie = categorizeHand(this.hand);
    }


    public List<Card> getCards() {
        return new ArrayList<>(this.hand);
    }

    public HandRankingCategorie getCategorie() {
        return this.categorie;
    }
 
    private HandRankingCategorie categorizeHand(List<Card> hand) {
        Map<Suit, Integer> suitFrequency = new HashMap<>();
        Arrays.stream(Suit.values()).forEach(suit -> suitFrequency.put(suit, 0));

        Map<Hank, Integer> hankFrequency = new HashMap<>();
        Arrays.stream(Hank.values()).forEach(hank -> hankFrequency.put(hank, 0));

        hand.forEach(card -> {
            Hank h = card.getHank();
            Suit s = card.getSuit();
            int f = hankFrequency.get(h);
            hankFrequency.put(h, f + 1);
            f = suitFrequency.get(s);
            suitFrequency.put(s, f + 1);
        });

        if (suitFrequency.entrySet().stream().filter(entry -> entry.getValue() != 0).distinct().count() == 1) {
            if (isStraight(hand)) {
                return HandRankingCategorie.STRAIGHT_FLUSH;
            }

            return HandRankingCategorie.FLUSH;
        }

        if (hankFrequency.values().stream().filter(f -> f == 4).count() > 0) {
            return HandRankingCategorie.FOUR_OF_A_KIND;
        }

        if (hankFrequency.entrySet().stream().filter(entry -> entry.getValue() != 0).distinct().count() == 2) {
            return HandRankingCategorie.FULL_HOUSE;
        }

        if (isStraight(hand)) {
            return HandRankingCategorie.STRAIGHT;
        }

        if (hankFrequency.values().stream().filter(f -> f == 3).count() == 1) {
            return HandRankingCategorie.THREE_OF_A_KIND;
        }

        if (hankFrequency.values().stream().filter(f -> f == 2).count() == 2) {
            return HandRankingCategorie.TWO_PAIR;
        }

        if (hankFrequency.values().stream().filter(f -> f == 2).count() == 1) {
            return HandRankingCategorie.ONE_PAIR;
        }

        return HandRankingCategorie.HIGH_CARD;
    }

    private boolean isStraight(List<Card> list) {
        List<Hank> hankList = new ArrayList<>();
        list.forEach(card -> hankList.add(card.getHank()));
        Collections.sort(hankList);
        List<Hank> values = Arrays.asList(Hank.values());
        int i0 = values.indexOf(hankList.get(0));
        int i1 = values.indexOf(hankList.get(1));
        int i2 = values.indexOf(hankList.get(2));
        int i3 = values.indexOf(hankList.get(3));
        int i4 = values.indexOf(hankList.get(4));

        if ((i1 == i0 + 1 && i2 == i1 + 1 && i3 == i2 + 1 && i4 == i3 + 1) ||
                (hankList.get(0).equals(Hank.TWO) 
                && hankList.get(1).equals(Hank.THREE)
                && hankList.get(2).equals(Hank.FOUR)
                && hankList.get(3).equals(Hank.FIVE)
                && hankList.get(4).equals(Hank.ACE))) {
            return true;
        }

        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        hand.forEach(card -> sb.append(card.toString()).append(" "));

        return sb.toString().trim();
    }

    @Override
    public int compareTo(Hand o) {
        
        return this.categorie.compareTo(o.getCategorie());
    }
}
