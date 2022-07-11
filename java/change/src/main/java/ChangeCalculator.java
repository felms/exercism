import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChangeCalculator {

    private final List<Integer> coins;

    public ChangeCalculator(List<Integer> coins) {
        this.coins = coins;
    }

    public List<Integer> computeMostEfficientChange(int change) {

        if (change < 0) {
            throw new IllegalArgumentException("Negative totals are not allowed.");
        }
        if (change == 0) {
            return Collections.emptyList();
        }
        if (this.coins.contains(change)) {
            return List.of(change);
        }

        // Pega todas as soluções possíveis
        List<List<Integer>> solutions = new ArrayList<>();
        computeAllChangeOptions(solutions, new ArrayList<>(), change);

        // Retorna erro não tenha sido encontrada nenhuma solução
        if (solutions.isEmpty()) {
            throw new IllegalArgumentException(
                    String.format("The total %d cannot be represented in the given currency.",
                            change));
        }

        // Ordena as soluções pelo número de moedas gasto
        // e retona o menor
        solutions.sort(Comparator.comparingInt(List::size));
        return solutions.get(0);

    }

    // Computa todas a combinaçãoes de moedas possíveis com as
    // moedas fornecidas e salva as que tem a soma igual ao
    // valor procurado
    private void computeAllChangeOptions(List<List<Integer>> solutions,
                                            List<Integer> currentSolution, int change) {

        if (change == 0) {
            solutions.add(currentSolution);
        } else {
            if (change < 0) {
                return;
            }

            for (int coin : this.coins) {
                List<Integer> newSolution = new ArrayList<>(currentSolution);
                newSolution.add(coin);
                computeAllChangeOptions(solutions, newSolution, change - coin);
            }
        }
    }

}