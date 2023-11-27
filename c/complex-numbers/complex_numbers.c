#include "complex_numbers.h"

complex_t c_add(complex_t a, complex_t b)
{
    return (complex_t) {a.real + b.real, a.imag + b.imag};
}

complex_t c_sub(complex_t a, complex_t b)
{
    return (complex_t) {a.real - b.real, a.imag - b.imag};
}

complex_t c_mul(complex_t a, complex_t b)
{
    return (complex_t) {
        a.real * b.real - a.imag * b.imag, 
        a.imag * b.real + a.real * b.imag
    };
}

complex_t c_div(complex_t a, complex_t b)
{
    return (complex_t) { 
        (a.real * b.real + a.imag * b.imag) / (b.real * b.real + b.imag * b.imag),
        (a.imag * b.real - a.real * b.imag) / (b.real * b.real + b.imag * b.imag)
    };
}

double c_abs(complex_t x)
{
    return sqrt(x.real * x.real + x.imag * x.imag);
}

complex_t c_conjugate(complex_t x)
{
    return (complex_t) {x.real, -x.imag};
}

double c_real(complex_t x)
{
    return x.real;
}

double c_imag(complex_t x)
{
    return x.imag;
}

complex_t c_exp(complex_t x)
{

    double mult = exp(x.real);
    return (complex_t) {
        mult * cos(x.imag),
        mult * sin(x.imag)
    };
}
