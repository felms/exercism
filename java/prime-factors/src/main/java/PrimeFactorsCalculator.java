import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class PrimeFactorsCalculator {

    public List<Long> calculatePrimeFactorsOf(long number) {
        
        List<Long> primeFactors = new ArrayList<>();
        long n = number;
        long factor = 0;
        while(n > 1 && factor <= n) {
            if (isPrime(factor) && n % factor == 0) {
                primeFactors.add(factor);
                n /= factor;
            } else {
                factor++;
            }
        }

        return primeFactors;
    }

    private boolean isPrime(long n) {

        if (n < 2) {
            return false;
        }

        return LongStream.rangeClosed(2, (long)Math.sqrt(n))
                    .noneMatch(number -> (n % number == 0));
                
    }
}
