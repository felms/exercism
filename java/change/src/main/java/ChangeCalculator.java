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

        this.coins.sort((a, b) -> b - a);

        List<Integer> solution = computeAllChangeOptions(new ArrayList<>(), change);

        // Retorna erro não tenha sido encontrada nenhuma solução
        if (solution == null) {
            throw new IllegalArgumentException(
                    String.format("The total %d cannot be represented in the given currency.",
                            change));
        }

        solution.sort(Comparator.comparingInt(a -> a));
        return solution;

    }

    // Computa todas a combinaçãoes de moedas possíveis com as
    // moedas fornecidas e salva as que tem a soma igual ao
    // valor procurado e depois retorna a com a menor qtde
    //  de moedas (ou null caso não seja possível calcular)
    private List<Integer> computeAllChangeOptions(List<Integer> currentSolution, int change) {

        if (change == 0) {
            return currentSolution;
        } else {
            if (change < 0) {
                return null;
            }

            List<Integer> bestSolution = new ArrayList<>();
            for (int coin : this.coins) {
                List<Integer> newSolution = new ArrayList<>(currentSolution);
                newSolution.add(coin);
                List<Integer> sol = computeAllChangeOptions(newSolution, change - coin);
                if (sol != null
                        && (bestSolution.isEmpty() || sol.size() < bestSolution.size())) {
                    bestSolution = new ArrayList<>(sol);
                }
            }

            return bestSolution.isEmpty() ? null: bestSolution;
        }
    }

}