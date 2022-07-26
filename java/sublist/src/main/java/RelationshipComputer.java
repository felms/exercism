import java.util.Collections;
import java.util.List;

public class RelationshipComputer<T> {

    public Relationship computeRelationship(List<T> a, List<T> b) {

        if (a.size() > b.size()) {
            if (Collections.indexOfSubList(a, b) >= 0) {
                return Relationship.SUPERLIST;
            }
        } else if (b.size() > a.size()) {
            if (Collections.indexOfSubList(b, a) >= 0) {
                return Relationship.SUBLIST;
            }
        } else {
            if (Collections.indexOfSubList(a, b) == 0) {
                return Relationship.EQUAL;
            }
        }

        return Relationship.UNEQUAL;
    }
}