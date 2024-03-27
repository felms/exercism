import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Sieve {

    private boolean[] sieve;

    Sieve(int maxPrime) {
        this.sieve = new boolean[maxPrime + 1];
        Arrays.fill(this.sieve, true);

        this.sieve[0] = false;
        this.sieve[1] = false;

        for (int i = 2; i <= maxPrime; i++) {
            if (this.sieve[i]) {
                for (int j = i + i; j <= maxPrime; j += i) {
                    this.sieve[j] = false;
                }
            }
        }
    }

    List<Integer> getPrimes() {
        return IntStream.range(2, this.sieve.length)
                    .filter(index -> this.sieve[index])
                    .boxed()
                    .toList();
    }
}
