import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        theirCollection.removeAll(myCollection);
        return !myCollection.isEmpty() && !theirCollection.isEmpty();
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> common = new HashSet<>(collections.get(0));
        collections.forEach(common::retainAll);
        return common;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> allCards = new HashSet<>();
        collections.forEach(allCards::addAll);
        return allCards;
    }
}
