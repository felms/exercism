import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Sieve {
    private boolean[] isPrime;

    Sieve(int maxPrime) {
        isPrime = new boolean[maxPrime + 1];
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < maxPrime + 1; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < maxPrime + 1; i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j < maxPrime + 1; j++) {
                    isPrime[j * i] = false;
                }
            }
        }
    }

    List<Integer> getPrimes() {
        return IntStream.range(2, isPrime.length)
                        .filter(candidate -> isPrime[candidate])
                        .boxed()
                        .collect(Collectors.toList());
    }
}
