import java.util.ArrayList;
import java.util.List;

class PrimeCalculator {

    int nth(int nth) {

        if (nth < 1) {
            throw new IllegalArgumentException();
        }

        List<Integer> primes = new ArrayList<>();

        for (int i = 0; primes.size() < nth; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

       return primes.get(nth - 1);
    }

    private boolean isPrime(int n) {

        if (n < 2) {
            return false;
        }

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
