import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SumOfMultiples {

    private Set<Integer> multiples;
    SumOfMultiples(int number, int[] set) {
        
        multiples = new HashSet<>();

        Arrays.stream(set).forEach(item -> {

            if (item != 0) {
                multiples.addAll(IntStream.range(1, number)
                                            .filter(i -> i % item == 0)
                                            .boxed()
                                            .collect(Collectors.toSet())
                                );
            }
            
        });
    }

    int getSum() {
        return multiples.stream().reduce(0, Integer::sum);
    }

}
