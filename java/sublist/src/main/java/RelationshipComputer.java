import java.util.List;
import java.util.stream.Collectors;

public class RelationshipComputer<T> {

    public Relationship computeRelationship(List<T> a, List<T> b) {

        String firstString = a.stream().map(String::valueOf)
                .collect(Collectors.joining(","));
        String secondString = b.stream().map(String::valueOf)
                .collect(Collectors.joining(","));

        if (firstString.equals(secondString)) {
            return Relationship.EQUAL;
        }

        if (firstString.contains(secondString)) {
            return Relationship.SUPERLIST;
        }

        if (secondString.contains(firstString)) {
            return Relationship.SUBLIST;
        }

        return Relationship.UNEQUAL;
    }
}