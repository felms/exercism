import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class PrimeFactorsCalculator {

    public List<Long> calculatePrimeFactorsOf(long number) {
        
        List<Long> primesList = LongStream.rangeClosed(0, number)
                    .filter(this::isPrime)
                    .boxed()
                    .collect(Collectors.toList());
        
        List<Long> primeFactors = new ArrayList<>();
        long n = number;
        int pos = 0;
        while(n > 1 && pos < primesList.size()) {
            long prime = primesList.get(pos);
            if (n % prime == 0) {
                primeFactors.add(prime);
                n /= prime;
            } else {
                pos++;
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
