class PrimeCalculator {

    int nth(int nth) {

        if (nth < 1) {
            throw new IllegalArgumentException();
        }

        int count = 1;
        int currentPrime = 2;

        while (count < nth) {
            while (!isPrime(++currentPrime));
            count++;
        }

        return currentPrime;
    }

    boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }

        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
