public class Card implements Comparable<Card>{

    private final String suit;
    private final String hank;

    public Card(String card) {
        this.hank = card.replaceAll("[CDHS]", "");
        this.suit = card.replaceAll("[^CDHS]", "");
    }

    int getHankValue() {
        return this.hank.matches("\\d")
                ? Integer.parseInt(this.hank)
                : switch (this.hank) {
                    case "J" -> 11;
                    case "Q" -> 12;
                    case "K" -> 13;
                    case "A" -> 14;
                    default -> -1;
                };
    }

    public String getSuit() {
        return this.suit;
    }

    @Override
    public int compareTo(Card o) {
        return this.getHankValue() - o.getHankValue();
    }

    @Override
    public String toString() {
        return this.hank + this.suit;
    }
}
