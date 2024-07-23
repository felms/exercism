export class Rational {

    constructor(numerator, denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    add(other) {
        let num = this.numerator * other.denominator + other.numerator * this.denominator;
        let den = this.denominator * other.denominator;
        return new Rational(num, den).reduce();
    }

    sub(other) {
        let num = this.numerator * other.denominator - other.numerator * this.denominator;
        let den = this.denominator * other.denominator;
        return new Rational(num, den).reduce();
    }

    mul(other) {
        let num = this.numerator * other.numerator;
        let den = this.denominator * other.denominator;
        return new Rational(num, den).reduce();
    }

    div(other) {
        let num = this.numerator * other.denominator;
        let den = other.numerator * this.denominator;
        return new Rational(num, den).reduce();
    }

    abs() {
        let n = Math.abs(this.numerator);
        let d = Math.abs(this.denominator);
        return new Rational(n, d);
    }

    exprational(number) {
        let n = Math.abs(number);
        return new Rational(this.numerator ** n, this.denominator ** n).reduce();
    }

    expreal(number) {
        return Math.pow(Math.pow(number, 1.0 / this.denominator), this.numerator);
    }

    reduce() {
        let g = gcd(this.numerator, this.denominator);
        let n = this.numerator / g;
        let d = this.denominator / g;

        if (d < 0 && n > 0) {
            n *= -1;
            d *= -1;
        }

        return new Rational(n, d);
    }
}

const gcd = (a, b) => b === 0 ? a : gcd(b, a % b);
