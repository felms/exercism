import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SumOfMultiples {

    private int sum;

    SumOfMultiples(int number, int[] set) {
        this.sum = Arrays.stream(set)
                    .mapToObj(n -> getMultiplesUtilLimit(n, number))
                    .flatMap(list -> list.stream())
                    .mapToInt(i -> i).distinct().sum();
    }

    int getSum() {
        return sum;
    }

    private List<Integer> getMultiplesUtilLimit(int number, int limit) {
        return number == 0 
                ? List.of()
                : IntStream.range(1, limit)
                    .filter(n -> n % number == 0).boxed().toList();
    }
}
