import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Poker {

    public static void main(String[] args) {
        String kicker8 = "JD QH JS 8D QC";
        String kicker2 = "JS QS JC 2D QD";
        Poker poker = new Poker(Arrays.asList(kicker8, kicker2));
        poker.getBestHands().forEach(System.out::println);
    }

    private final List<Hand> hands;

    public Poker(List<String> inputHands) {
        this.hands = new ArrayList<>();
        inputHands.forEach(h -> hands.add(new Hand(h)));
    }

    public List<String> getBestHands() {

        if (this.hands.size() == 1) {

            return List.of(this.hands.get(0).toString());

        }

        Collections.sort(this.hands);
        Collections.reverse(this.hands);
          
        Hand h0 = this.hands.get(0);
        Hand h1 = this.hands.get(1);

        if (h0.getCategorie().equals(h1.getCategorie())) {
            return tieBreaker(h1, h0);
        }        

        return List.of(h0.toString());
    }

    private List<String> tieBreaker(Hand hand0, Hand hand1) {
        HandRankingCategorie categorie = hand0.getCategorie();

        if (categorie.equals(HandRankingCategorie.HIGH_CARD) 
                || categorie.equals(HandRankingCategorie.FLUSH)) {
            List<Card> c0 = hand0.getCards();
            Collections.sort(c0);
            Collections.reverse(c0);
            List<Card> c1 = hand1.getCards();
            Collections.sort(c1);
            Collections.reverse(c1);

            for (int i = 0; i < c0.size(); i++) {
                if (c0.get(i).compareTo(c1.get(i)) > 0) {
                    return List.of(hand0.toString());
                } else if (c1.get(i).compareTo(c0.get(i)) > 0) {
                    return List.of(hand1.toString());
                }
            }

            return List.of(hand0.toString(), hand1.toString());

        }

        if (categorie.equals(HandRankingCategorie.STRAIGHT)
            || categorie.equals(HandRankingCategorie.STRAIGHT_FLUSH)) {

            List<Card> c0 = hand0.getCards();
            Collections.sort(c0);
            Collections.reverse(c0);
            List<Card> c1 = hand1.getCards();
            Collections.sort(c1);
            Collections.reverse(c1);

            if (c0.get(0).getHank().equals(Hank.ACE)
                && c1.get(0).getHank().equals(Hank.ACE)) {
                for (int i = 0; i < c0.size(); i++) {
                    if (c0.get(i).compareTo(c1.get(i)) > 0) {
                        return List.of(hand0.toString());
                    } else if (c1.get(i).compareTo(c0.get(i)) > 0) {
                        return List.of(hand1.toString());
                    }
                }
                return List.of(hand0.toString(), hand1.toString());

            } else if (c0.get(0).getHank().equals(Hank.ACE) 
                        && c0.get(c0.size() - 1).getHank().equals(Hank.TWO)) {
                c0.remove(0);
                for (int i = 0; i < c0.size(); i++) {
                    if (c0.get(i).compareTo(c1.get(i)) > 0) {
                        return List.of(hand0.toString());
                    } else if (c1.get(i).compareTo(c0.get(i)) > 0) {
                        return List.of(hand1.toString());
                    }
                }
            } else if (c1.get(0).getHank().equals(Hank.ACE) 
                        && c1.get(c1.size() - 1).getHank().equals(Hank.TWO)) {
                c1.remove(0);
                for (int i = 0; i < c1.size(); i++) {
                    if (c0.get(i).compareTo(c1.get(i)) > 0) {
                        return List.of(hand0.toString());
                    } else if (c1.get(i).compareTo(c0.get(i)) > 0) {
                        return List.of(hand1.toString());
                    }
                }
            } else {
                for (int i = 0; i < c0.size(); i++) {
                    if (c0.get(i).compareTo(c1.get(i)) > 0) {
                        return List.of(hand0.toString());
                    } else if (c1.get(i).compareTo(c0.get(i)) > 0) {
                        return List.of(hand1.toString());
                    }
                }
    
                return List.of(hand0.toString(), hand1.toString());
            }

        }

        Map<Suit, Integer> suitFrequency0 = new HashMap<>();
        Arrays.stream(Suit.values()).forEach(suit -> suitFrequency0.put(suit, 0));

        Map<Hank, Integer> hankFrequency0 = new HashMap<>();
        Arrays.stream(Hank.values()).forEach(hank -> hankFrequency0.put(hank, 0));

        hand0.getCards().forEach(card -> {
            Hank h = card.getHank();
            Suit s = card.getSuit();
            int f = hankFrequency0.get(h);
            hankFrequency0.put(h, f + 1);
            f = suitFrequency0.get(s);
            suitFrequency0.put(s, f + 1);
        });

        Map<Suit, Integer> suitFrequency1 = new HashMap<>();
        Arrays.stream(Suit.values()).forEach(suit -> suitFrequency1.put(suit, 0));

        Map<Hank, Integer> hankFrequency1 = new HashMap<>();
        Arrays.stream(Hank.values()).forEach(hank -> hankFrequency1.put(hank, 0));

        hand1.getCards().forEach(card -> {
            Hank h = card.getHank();
            Suit s = card.getSuit();
            int f = hankFrequency1.get(h);
            hankFrequency1.put(h, f + 1);
            f = suitFrequency1.get(s);
            suitFrequency1.put(s, f + 1);
        });

        if(categorie.equals(HandRankingCategorie.ONE_PAIR)) {
            Hank cardHank0 = hankFrequency0.entrySet().stream().filter(hank -> hank.getValue() == 2).findFirst().get().getKey();
            Hank cardHank1 = hankFrequency1.entrySet().stream().filter(hank -> hank.getValue() == 2).findFirst().get().getKey();
            if (cardHank0.compareTo(cardHank1) > 0) {
                return List.of(hand0.toString());
            } else if (cardHank1.compareTo(cardHank0) > 0) {
                return List.of(hand1.toString());
            }

            return List.of(hand0.toString(), hand1.toString());

        }

        if(categorie.equals(HandRankingCategorie.TWO_PAIR)) {
            
            List<Hank> cardHank0 = hankFrequency0.entrySet().stream().filter(hank -> hank.getValue() == 2)
                        .sorted((a, b) -> a.getKey().compareTo(b.getKey())).map(a -> a.getKey()).toList();
            List<Hank> cardHank1 = hankFrequency1.entrySet().stream().filter(hank -> hank.getValue() == 2)
                        .sorted((a, b) -> a.getKey().compareTo(b.getKey())).map(a -> a.getKey()).toList();
            Hank hank0 = cardHank0.get(cardHank0.size() - 1);
            Hank hank1 = cardHank1.get(cardHank0.size() - 1);
            System.out.println("H0: " + hank0);
            System.out.println("H1: " + hank1);

            // Compara o par maior
            if (hank0.compareTo(hank1) > 0) {
                return List.of(hand0.toString());
            } else if (hank1.compareTo(hank0) > 0) {
                return List.of(hand1.toString());
            }

            hank0 = cardHank0.get(0);
            hank1 = cardHank1.get(0);
            System.out.println("H0: " + hank0);
            System.out.println("H1: " + hank1);

            // Compara o par menor
            if (hank0.compareTo(hank1) > 0) {
                return List.of(hand0.toString());
            } else if (hank1.compareTo(hank0) > 0) {
                return List.of(hand1.toString());
            }

            hank0 = hankFrequency0.entrySet().stream().filter(hank -> hank.getValue() == 1).toList().get(0).getKey();
            hank1 = hankFrequency1.entrySet().stream().filter(hank -> hank.getValue() == 1).toList().get(0).getKey();

            // Compara o item que sobra
            if (hank0.compareTo(hank1) > 0) {
                return List.of(hand0.toString());
            } else if (hank1.compareTo(hank0) > 0) {
                return List.of(hand1.toString());
            }

            return List.of(hand0.toString(), hand1.toString());
        }

        if(categorie.equals(HandRankingCategorie.THREE_OF_A_KIND)) {
            Hank cardHank0 = hankFrequency0.entrySet().stream().filter(hank -> hank.getValue() == 3).findFirst().get().getKey();
            Hank cardHank1 = hankFrequency1.entrySet().stream().filter(hank -> hank.getValue() == 3).findFirst().get().getKey();
            if (cardHank0.compareTo(cardHank1) > 0) {
                return List.of(hand0.toString());
            } else if (cardHank1.compareTo(cardHank0) > 0) {
                return List.of(hand1.toString());
            }

            List<Card> cards0 = hand0.getCards().stream().filter(card -> card.getHank() != cardHank0).sorted().toList();
            List<Card> cards1 = hand1.getCards().stream().filter(card -> card.getHank() != cardHank1).sorted().toList();
            
            
            if (cards0.get(1).compareTo(cards1.get(1)) > 0) {
                return List.of(hand0.toString());
            } else if (cards1.get(1).compareTo(cards0.get(1)) > 0) {
                return List.of(hand1.toString());
            }            

            return List.of(hand0.toString(), hand1.toString());
        
        }

        if(categorie.equals(HandRankingCategorie.FULL_HOUSE)) {
            Hank cardHank0 = hankFrequency0.entrySet().stream().filter(hank -> hank.getValue() == 3).findFirst().get().getKey();
            Hank cardHank1 = hankFrequency1.entrySet().stream().filter(hank -> hank.getValue() == 3).findFirst().get().getKey();
            if (cardHank0.compareTo(cardHank1) > 0) {
                return List.of(hand0.toString());
            } else if (cardHank1.compareTo(cardHank0) > 0) {
                return List.of(hand1.toString());
            }

            cardHank0 = hankFrequency0.entrySet().stream().filter(hank -> hank.getValue() == 2).findFirst().get().getKey();
            cardHank1 = hankFrequency1.entrySet().stream().filter(hank -> hank.getValue() == 2).findFirst().get().getKey();

            if (cardHank0.compareTo(cardHank1) > 0) {
                return List.of(hand0.toString());
            } else if (cardHank1.compareTo(cardHank0) > 0) {
                return List.of(hand1.toString());
            }

            return List.of(hand0.toString(), hand1.toString());
        
        }

        if(categorie.equals(HandRankingCategorie.FOUR_OF_A_KIND)) {
            Hank cardHank0 = hankFrequency0.entrySet().stream().filter(hank -> hank.getValue() == 4).findFirst().get().getKey();
            Hank cardHank1 = hankFrequency1.entrySet().stream().filter(hank -> hank.getValue() == 4).findFirst().get().getKey();
            if (cardHank0.compareTo(cardHank1) > 0) {
                return List.of(hand0.toString());
            } else if (cardHank1.compareTo(cardHank0) > 0) {
                return List.of(hand1.toString());
            }

            cardHank0 = hankFrequency0.entrySet().stream().filter(hank -> hank.getValue() == 1).findFirst().get().getKey();
            cardHank1 = hankFrequency1.entrySet().stream().filter(hank -> hank.getValue() == 1).findFirst().get().getKey();
            if (cardHank0.compareTo(cardHank1) > 0) {
                return List.of(hand0.toString());
            } else if (cardHank1.compareTo(cardHank0) > 0) {
                return List.of(hand1.toString());
            }

            return List.of(hand0.toString(), hand1.toString());
        
        }
        return null;
    }


}

enum HandRankingCategorie {
    HIGH_CARD, ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, 
    FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH, FIVE_OF_A_KIND;
}




