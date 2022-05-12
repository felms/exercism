public class Card implements Comparable<Card>{
    private final Hank hank;
    private final Suit suit;
    public Card(String card) {
        String[] c = card.split("");
        String s = c[c.length - 1];
        String h = card.replaceAll(s, "");

        switch(s) {
            case "C":
                this.suit = Suit.CLUBS;
                break;
            case "D":
                this.suit = Suit.DIAMONDS;
                break;
            case "S":
                this.suit = Suit.SPADES;
                break;
            case "H":
                this.suit = Suit.HEARTS;
                break;
            default:
                throw new IllegalArgumentException();
        }

        switch(h) {
            case "A":
                this.hank = Hank.ACE;
                break;
            case "2":
                this.hank = Hank.TWO;
                break;
            case "3":
                this.hank = Hank.THREE;
                break;
            case "4":
                this.hank = Hank.FOUR;
                break;
            case "5":
                this.hank = Hank.FIVE;
                break;
            case "6":
                this.hank = Hank.SIX;
                break;
            case "7":
                this.hank = Hank.SEVEN;
                break;
            case "8":
                this.hank = Hank.EIGHT;
                break;
            case "9":
                this.hank = Hank.NINE;
                break;
            case "10":
                this.hank = Hank.TEN;
                break;
            case "J":
                this.hank = Hank.JACK;
                break;
            case "Q":
                this.hank = Hank.QUEEN;
                break;
            case "K":
                this.hank = Hank.KING;
                break;
            case "JK":
                this.hank = Hank.JOKER;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Hank getHank() {
        return this.hank;
    }

    public String toString() {
        return this.hank.toString() + this.suit.toString();
    }

    @Override
    public int compareTo(Card o) {
        return this.getHank().compareTo(o.getHank());
    }
}

enum Suit {
    CLUBS("C"), 
    DIAMONDS("D"), 
    SPADES("S"), 
    HEARTS("H");

    private final String name;

    private Suit(String s) {
        this.name = s;
    }

    public String toString() {
        return this.name;
    }
}

enum Hank {
    TWO("2"), THREE("3"), FOUR("4"), FIVE("5"),
    SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"),
    JACK("J"), QUEEN("Q"), KING("K"),  ACE("A"), JOKER("JK");

    private final String name;

    private Hank(String s) {
        this.name = s;
    }

    public String toString() {
        return this.name;
    }
}