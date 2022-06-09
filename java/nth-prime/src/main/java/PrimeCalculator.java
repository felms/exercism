import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class PrimeCalculator {

    int nth(int nth) {

        if (nth < 1) {
            throw new IllegalArgumentException();
        }

        List<Integer> primes = IntStream.range(0, 1_000_000)
                                .filter(this::isPrime)
                                .boxed()
                                .collect(Collectors.toList());

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
