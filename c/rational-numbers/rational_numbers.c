#include "rational_numbers.h"

#include <stdlib.h>
#include <math.h>

rational_t add(rational_t r1, rational_t r2) {

    int num = r1.numerator * r2.denominator + r1.denominator * r2.numerator;
    int den = r1.denominator * r2.denominator;

    return reduce((rational_t) {num, den});
}

rational_t subtract(rational_t r1, rational_t r2) {

    int num = r1.numerator * r2.denominator - r1.denominator * r2.numerator;
    int den = r1.denominator * r2.denominator;

    return reduce((rational_t) {num, den});
}

rational_t multiply(rational_t r1, rational_t r2) {

    int num = r1.numerator * r2.numerator;
    int den = r1.denominator * r2.denominator;

    return reduce((rational_t) {num, den});
}

rational_t divide(rational_t r1, rational_t r2) {

    int num = r1.numerator * r2.denominator;
    int den = r2.numerator * r1.denominator;

    return reduce((rational_t) {num, den});
}

rational_t absolute(rational_t rational) {

    int num = abs(rational.numerator);
    int den = abs(rational.denominator);

    return reduce((rational_t) {num, den});
}

rational_t exp_rational(rational_t rational, int exponent) {

    int num = pow(rational.numerator, abs(exponent));
    int den = pow(rational.denominator, abs(exponent));

    if (exponent < 0) {
        int aux = num;
        num = den;
        den = aux;

        if (exponent % 2 != 0 && den < 0) {
            num = -num;
            den = -den;
        }

    }

    return (rational_t) {num, den};
}

float exp_real(int number, rational_t rational) {

    float p = pow(number, rational.numerator);
    float q = 1.0 / rational.denominator;

    return pow(p, q);

}
rational_t reduce(rational_t rational) {
    int num = rational.numerator;
    int den = rational.denominator;

    if (den < 0) {
        num = -num;
        den = -den;
    }

    int the_gcd = abs(gcd(num, den));

    return (rational_t) { num / the_gcd, den / the_gcd };
}

int gcd (int a, int b) {
    if (b == 0) {
        return a;
    } else {
        return gcd(b, a % b);
    }
}
