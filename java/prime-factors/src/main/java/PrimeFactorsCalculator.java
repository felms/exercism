import java.util.ArrayList;
import java.util.List;

class PrimeFactorsCalculator {

    List<Long> calculatePrimeFactorsOf(long number) {

        List<Long> res = new ArrayList<>();
        long n = number;
        long i = 2;

        while(n > 1) {
            while (n % i == 0) {
                n /= i;
                res.add(i);
            }

            i++;
        }

        return res;
    }

}
