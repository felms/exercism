class Rational {

    private final int numerator;
    private final int denominator;

    Rational(int numerator, int denominator) {
        int num = numerator;

        if (denominator == 0) {
            throw new IllegalArgumentException("The denominator can't be zero");
        }

        int den = denominator;

        int gcd = gcd(num, den);

        this.numerator = num / gcd;
        this.denominator = den / gcd;
    }

    int getNumerator() {
        return this.numerator;
    }

    int getDenominator() {
        return this.denominator;
    }

    public Rational add(Rational other) {

        int a1 = this.getNumerator();
        int b1 = this.getDenominator();
        int a2 = other.getNumerator();
        int b2 = other.getDenominator();

        int newNumerator = a1 * b2 + a2 * b1;
        int newDenominator = b1 * b2;

        return new Rational(newNumerator, newDenominator);
    }

    public Rational subtract(Rational other) {
        int a1 = this.getNumerator();
        int b1 = this.getDenominator();
        int a2 = other.getNumerator();
        int b2 = other.getDenominator();

        int newNumerator = a1 * b2 - a2 * b1;
        int newDenominator = b1 * b2;

        return new Rational(newNumerator, newDenominator);
    }

    public Rational multiply(Rational other) {
        return null; // TODO
    }

    public Rational divide(Rational other) {
        return null; // TODO
    }

    public Rational abs() {
        return null; // TODO
    }

    public Rational pow(int exponent) {
        return null; // TODO
    }

    public double exp(double exponent) {
        return -1; // TODO
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }

        return gcd(b, a % b);
    }


    @Override
    public String toString() {
        return String.format("%d/%d", this.getNumerator(), this.getDenominator());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !this.getClass().isAssignableFrom(obj.getClass())) {
            return false;
        }

        Rational other = (Rational) obj;
        return this.getNumerator() == other.getNumerator()
            && this.getDenominator() == other.getDenominator();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + this.getNumerator();
        result = prime * result + this.getDenominator();

        return result;
    }
}
