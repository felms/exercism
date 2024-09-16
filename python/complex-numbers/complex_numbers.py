import math


class ComplexNumber:
    def __init__(self, real, imaginary):
        self.real = real
        self.imaginary = imaginary

    def __eq__(self, other):
        return self.real == other.real and self.imaginary == other.imaginary

    def __add__(self, other):
        if not isinstance(other, ComplexNumber):
            return ComplexNumber(self.real + other, self.imaginary)

        return ComplexNumber(
            self.real + other.real, self.imaginary + other.imaginary)

    def __radd__(self, other):
        return self + other

    def __mul__(self, other):
        if not isinstance(other, ComplexNumber):
            return ComplexNumber(self.real * other, self.imaginary * other)

        return ComplexNumber(
            self.real * other.real - self.imaginary * other.imaginary,
            self.imaginary * other.real + self.real * other.imaginary)

    def __rmul__(self, other):
        return self * other

    def __sub__(self, other):
        if not isinstance(other, ComplexNumber):
            return ComplexNumber(self.real - other, self.imaginary)

        return ComplexNumber(self.real - other.real,
                             self.imaginary - other.imaginary)

    def __rsub__(self, other):
        return ComplexNumber(other, 0) - self

    def __truediv__(self, other):
        if not isinstance(other, ComplexNumber):
            return ComplexNumber(self.real / other, self.imaginary / other)

        den = other.real ** 2 + other.imaginary ** 2

        return ComplexNumber(
            (self.real * other.real + self.imaginary * other.imaginary) / den,
            (self.imaginary * other.real - self.real * other.imaginary) / den)

    def __rtruediv__(self, other):
        return ComplexNumber(other, 0) / self

    def __abs__(self):
        return math.sqrt(self.real ** 2 + self.imaginary ** 2)

    def conjugate(self):
        return ComplexNumber(self.real, -self.imaginary)

    def exp(self):
        mul = math.e ** self.real

        return ComplexNumber(
            mul * math.cos(self.imaginary), mul * math.sin(self.imaginary))
