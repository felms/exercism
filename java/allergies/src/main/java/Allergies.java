import java.util.Arrays;
import java.util.List;

class Allergies {
    private int score;
    Allergies(int score) {
        this.score = score;
    }

    boolean isAllergicTo(Allergen allergen) {
        return (this.score & allergen.getScore()) > 0;
    }

    List<Allergen> getList() {
        return Arrays.stream(Allergen.values())
                .filter(this::isAllergicTo)
                .toList();
    }
}
