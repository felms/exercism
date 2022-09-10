import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PythagoreanTriplet {

    private final int a;
    private final int b;
    private final int c;

    public PythagoreanTriplet(int a, int b, int c) {

        this.a = a;
        this.b = b;
        this.c = c;
    }
    public static PythagoreanTripletBuilder makeTripletsList() {
        return new PythagoreanTripletBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PythagoreanTriplet that = (PythagoreanTriplet) o;
        return a == that.a && b == that.b && c == that.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "PythagoreanTriplet{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }


    static class PythagoreanTripletBuilder {

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

}