import java.util.Objects;

class Rational {

    private final int numerator;
    private final int denominator;

    Rational(int numerator, int denominator) {
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    int getNumerator() {
        return this.numerator;
    }

    int getDenominator() {
        return this.denominator;
    }

    Rational add(Rational other) {
        return new Rational(
                this.getNumerator() * other.getDenominator() + other.getNumerator() * this.getDenominator(),
                this.getDenominator() * other.getDenominator());
    }

    Rational subtract(Rational other) {
        return new Rational(
                this.getNumerator() * other.getDenominator() - other.getNumerator() * this.getDenominator(),
                this.getDenominator() * other.getDenominator());
    }

    Rational multiply(Rational other) {
        return new Rational(
                this.getNumerator() * other.getNumerator(),
                this.getDenominator() * other.getDenominator());
    }

    Rational divide(Rational other) {
        return new Rational(
                this.getNumerator() * other.getDenominator(),
                other.getNumerator() * this.getDenominator());
    }

    Rational abs() {
        return new Rational(Math.abs(this.getNumerator()), Math.abs(this.getDenominator()));
    }

    Rational pow(int power) {
        if (power > 0) {
            return new Rational(
                    (int) Math.pow(this.getNumerator(), power),
                    (int) Math.pow(this.getDenominator(), power));
        }

        int m = Math.abs(power);
        return new Rational(
                (int) Math.pow(this.getDenominator(), m),
                (int) Math.pow(this.getNumerator(), m));
    }

    double exp(double exponent) {
        return Math.pow(Math.pow(exponent, this.getNumerator()), 1.0 / this.getDenominator());
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.getNumerator(), this.getDenominator());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rational other) {
            return this.getNumerator() == other.getNumerator()
                    && this.getDenominator() == other.getDenominator();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getNumerator(), this.getDenominator());
    }
}
