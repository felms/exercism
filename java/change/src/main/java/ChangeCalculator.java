import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChangeCalculator {

    private final List<Integer> coins;

    public ChangeCalculator(List<Integer> coins) {
        this.coins = coins;
    }

    public List<Integer> computeMostEfficientChange(int amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Negative totals are not allowed.");
        }
        if (amount == 0) {
            return Collections.emptyList();
        }
        if (this.coins.contains(amount)) {
            return List.of(amount);
        }

        this.coins.sort(Comparator.comparingInt(a -> a));

        List<Integer> solution = computeChange(amount);

        // Retorna erro não tenha sido encontrada nenhuma solução
        if (solution == null) {
            throw new IllegalArgumentException(
                    String.format("The total %d cannot be represented in the given currency.",
                            amount));
        }

        solution.sort(Comparator.comparingInt(a -> a));
        return solution;

    }

    // Computa as combinaçãoes de moedas possíveis com as
    // moedas fornecidas partindo dos menores casos
    // reutilizando as soluções dos mesmos para
    // casos maiores
    private List<Integer> computeChange(int amount) {

        // Cria e inicializa um mapa com as soluções iniciais
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= amount; i++) {
            list.add(amount + 1);
        }

        Map<Integer, List<Integer>> dp = new HashMap<>();
        for (int i = 0; i <= amount; i++) {
            dp.put(i, new ArrayList<>(list));
        }

        dp.put(0, new ArrayList<>());

        for (int i = 0; i <= amount; i++) {
            for (Integer coin : this.coins) {
                if (coin <= i) { // Se a moeda for menor que o valor atual sendo calculado
                    List<Integer> solForI = dp.get(i); // A solução atual para o valor 'i'

                    // Pego a melhor solução para o caso de valor 
                    // de ('i' - 'moedaAtual')
                    List<Integer> newL = new ArrayList<>(dp.get(i - coin));
                    // Adiciono a moeda à soma para gerar a solução para 
                    // o valor atual
                    newL.add(coin);

                    // Testo se a solução gerada é melhor que a solução existente
                    if (solForI.size() > newL.size()) {
                        dp.put(i, newL);
                    }
                }
            }
        }

        return dp.get(amount).stream()
                .mapToInt(Integer::intValue).sum() > amount
                ? null
                : dp.get(amount);
    }

}