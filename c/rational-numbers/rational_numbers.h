#ifndef RATIONAL_NUMBERS_H
#define RATIONAL_NUMBERS_H

typedef struct {
    int numerator;
    int denominator;
} rational_t;

rational_t add(rational_t r1, rational_t r2);
rational_t subtract(rational_t r1, rational_t r2);
rational_t multiply(rational_t r1, rational_t r2);
rational_t divide(rational_t r1, rational_t r2);
rational_t absolute(rational_t rational);
rational_t exp_rational(rational_t rational, int exponent);
float exp_real(int x, rational_t rational);
rational_t reduce(rational_t rational);
int gcd(int a, int b);

#endif
