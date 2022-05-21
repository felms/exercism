import java.util.ArrayList;
import java.util.List;

public class Allergies {

    private List<Allergen> allergens;

    public Allergies(int score) {
        this.allergens = new ArrayList<>();

        int binaryScore = Integer.parseInt(Integer.toString(score,2));

        if (binaryScore % 2 != 0) {
            this.allergens.add(Allergen.EGGS);
        }
        binaryScore /= 10;

        if (binaryScore % 2 != 0) {
            this.allergens.add(Allergen.PEANUTS);
        }
        binaryScore /= 10;

        if (binaryScore % 2 != 0) {
            this.allergens.add(Allergen.SHELLFISH);
        }
        binaryScore /= 10;

        if (binaryScore % 2 != 0) {
            this.allergens.add(Allergen.STRAWBERRIES);
        }
        binaryScore /= 10;

        if (binaryScore % 2 != 0) {
            this.allergens.add(Allergen.TOMATOES);
        }
        binaryScore /= 10;

        if (binaryScore % 2 != 0) {
            this.allergens.add(Allergen.CHOCOLATE);
        }
        binaryScore /= 10;

        if (binaryScore % 2 != 0) {
            this.allergens.add(Allergen.POLLEN);
        }
        binaryScore /= 10;

        if (binaryScore % 2 != 0) {
            this.allergens.add(Allergen.CATS);
        }
        binaryScore /= 10;

    }

    public boolean isAllergicTo(Allergen allergen) {

        return this.allergens.contains(allergen);
    }

    public List<Allergen> getList() {
        return this.allergens;
    }
    
}