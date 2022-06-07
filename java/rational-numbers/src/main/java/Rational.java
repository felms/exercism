class Rational {

    private final int numerator;
    private final int denominator;

    Rational(int numerator, int denominator) {
        int num = numerator;

        if (denominator == 0) {
            throw new IllegalArgumentException("The denominator can't be zero");
        }

        int den = denominator;

        if (den < 0 && num > 0) {
            num *= -1;
            den *= -1;
        }

        

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
        int a1 = this.getNumerator();
        int b1 = this.getDenominator();
        int a2 = other.getNumerator();
        int b2 = other.getDenominator();

        int newNumerator = a1 * a2;
        int newDenominator = b1 * b2;

        return new Rational(newNumerator, newDenominator);
    }

    public Rational divide(Rational other) {
        int a1 = this.getNumerator();
        int b1 = this.getDenominator();
        int a2 = other.getNumerator();
        int b2 = other.getDenominator();

        if (a2 == 0) {
            throw new IllegalArgumentException("The numerator of the second rational can't be zero. (Can't divide by zero)");
        }

        if (a1 < 0 && a2 < 0) {
            a1 *= -1;
            a2 *= -1;
        }

        int newNumerator = a1 * b2;
        int newDenominator = a2 * b1;

        return new Rational(newNumerator, newDenominator);
    }

    public Rational abs() {
        int newNumerator = Math.abs(this.getNumerator());
        int newDenominator = Math.abs(this.getDenominator());

        return new Rational(newNumerator, newDenominator);
    }

    public Rational pow(int exponent) {
        int m = Math.abs(exponent);
        int newNumerator = (int) Math.pow(this.getNumerator(), m);
        int newDenominator = (int) Math.pow(this.getDenominator(), m);
        return new Rational(newNumerator, newDenominator);
    }

    public double exp(double exponent) {

        return Math.pow(Math.pow(exponent, 1.0 / this.getDenominator()), this.getNumerator());
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
