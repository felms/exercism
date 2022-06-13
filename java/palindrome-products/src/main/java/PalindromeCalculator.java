import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class PalindromeCalculator {

    public SortedMap<Long, List<List<Integer>>> 
                        getPalindromeProductsWithFactors(int start, int end) {
        
        if (start > end) {
            throw new IllegalArgumentException("invalid input: min must be <= max");
        }

        SortedMap<Long, List<List<Integer>>> map = new TreeMap<>();

        for (int i = start; i <= end; i++) {
            for (int j = i; j <= end; j++) {
                List<Integer> factors = List.of(i, j);
                long product = i * j;

                if (isPalindrome(product)) {
                    if (map.containsKey(product)) {
                        List<List<Integer>> factorsList = map.get(product);
                        factorsList.add(factors);
                    } else {
                        List<List<Integer>> factorsList = new ArrayList<>();
                        factorsList.add(factors);
                        map.put(product, factorsList);
                    }
                }                
                
            }
        }

        return map;
    }

    private boolean isPalindrome(long number) {
        
        if (number > 0 && number < 10) {
            return true;
        }

        long n = number;
        long digit = 0;
        long reversedNumber = 0;
        while (n > 0) {
            digit = n % 10;
            n /= 10;
            reversedNumber = reversedNumber * 10 + digit;
        }

        return reversedNumber == number;
    }
}