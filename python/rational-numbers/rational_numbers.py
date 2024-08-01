class Rational:
    def __init__(self, numer, denom):
        gcd = self.__gcd(numer, denom)
        self.numer = numer / gcd
        self.denom = denom / gcd

    def __eq__(self, other):
        return self.numer == other.numer and self.denom == other.denom

    def __repr__(self):
        return f'{self.numer}/{self.denom}'

    def __add__(self, other):
        n = self.numer * other.denom + other.numer * self.denom
        d = self.denom * other.denom
        return Rational(n, d)

    def __sub__(self, other):
        n = self.numer * other.denom - other.numer * self.denom
        d = self.denom * other.denom
        return Rational(n, d)

    def __mul__(self, other):
        n = self.numer * other.numer
        d = self.denom * other.denom
        return Rational(n, d)

    def __truediv__(self, other):
        n = self.numer * other.denom
        d = other.numer * self.denom
        return Rational(n, d)

    def __abs__(self):
        return Rational(abs(self.numer), abs(self.denom))

    def __pow__(self, power):
        n = self.numer ** power if power > 0 else self.denom ** abs(power)
        d = self.denom ** power if power > 0 else self.numer ** abs(power)
        return Rational(n, d)

    def __rpow__(self, base):
        p = base ** self.numer
        return p ** (1 / self.denom)

    def __gcd(self, a, b):
        if b == 0:
            return a

        return self.__gcd(b, a % b)
