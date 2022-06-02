import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

        return IntStream.rangeClosed(2, (int)Math.sqrt(n))
                    .noneMatch(number -> (n % number == 0));
                
    }

}
