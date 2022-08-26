import java.security.cert.CertPathBuilder;
import java.util.ArrayList;
import java.util.List;

public class PythagoreanTripletBuilder {

    private int maxFactorValue;
    private int sumTo;

    public PythagoreanTripletBuilder() {
        this.maxFactorValue = Integer.MAX_VALUE;
        this.sumTo = Integer.MAX_VALUE;
    }

    public PythagoreanTripletBuilder thatSumTo(int i) {
        this.sumTo = i;
        return this;
    }

    public List<PythagoreanTriplet> build() {

        List<PythagoreanTriplet> triplets = new ArrayList<>();

        for (int a = 1; a < this.maxFactorValue && a < this.sumTo; a++) {
            for (int b = a + 1; b < this.maxFactorValue && b < this.sumTo; b++) {
                   int c = (int) Math.sqrt(a * a + b * b);
                   if (c <= this.maxFactorValue && a * a + b * b == c * c
                           && a + b + c == this.sumTo) {
                       triplets.add(new PythagoreanTriplet(a, b, c));
                   }
            }
        }

        return triplets;
    }

    public PythagoreanTripletBuilder withFactorsLessThanOrEqualTo(int i) {
        this.maxFactorValue = i;
        return this;
    }
}
