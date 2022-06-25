export class Rational {
  constructor(numerator, denominator) {

    if (denominator === 0) {
      throw new Error('the denominator can\'t be zero');
    }

     if (denominator < 0 && numerator >= 0) {
       numerator *= -1;
       denominator *= -1;
     }

    let d = Math.abs(this.gcd(numerator, denominator));

    this.numerator = numerator / d;
    this.denominator = denominator / d;
  }

  add(other) {
    let a1 = this.numerator;
    let b1 = this.denominator;
    let a2 = other.numerator;
    let b2 = other.denominator;

    let newNumerator = a1 * b2 + a2 * b1;
    let newDenominator = b1 * b2;

    return new Rational(newNumerator, newDenominator);
  }

  sub(other) {
    let a1 = this.numerator;
    let b1 = this.denominator;
    let a2 = other.numerator;
    let b2 = other.denominator;

    let newNumerator = a1 * b2 - a2 * b1;
    let newDenominator = b1 * b2;

    return new Rational(newNumerator, newDenominator);
  }

  mul(other) {
    let a1 = this.numerator;
    let b1 = this.denominator;
    let a2 = other.numerator;
    let b2 = other.denominator;

    let newNumerator = a1 * a2;
    let newDenominator = b1 * b2;

    return new Rational(newNumerator, newDenominator);
  }

  div(other) {
    let a1 = this.numerator;
    let b1 = this.denominator;
    let a2 = other.numerator;
    let b2 = other.denominator;

    if (a2 === 0) {
      throw new Error("The numerator of the second rational can't be zero. (Can't divide by zero)");
    }

    if (a1 < 0 && a2 < 0) {
      a1 *= -1;
      a2 *= -1;
    }

    let newNumerator = a1 * b2;
    let newDenominator = a2 * b1;

    return new Rational(newNumerator, newDenominator);
  }

  abs() {
    let a1 = Math.abs(this.numerator);
    let b1 = Math.abs(this.denominator);

    return new Rational(a1, b1);
  }

  exprational(exponent) {
    let m = Math.abs(exponent);
    let newNumerator = Math.pow(this.numerator, m);
    let newDenominator = Math.pow(this.denominator, m);
    return new Rational(newNumerator, newDenominator);
  }

  expreal(exponent) {
    return Math.pow(Math.pow(exponent, 1.0 / this.denominator), this.numerator);
  }

  reduce() {
    return this;
  }

  gcd(a, b) {
    if (b === 0) {
      return a;
    }

    return this.gcd(b, a % b);
  }
}
