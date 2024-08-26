import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ChangeCalculator {

    private List<Integer> coins;
    private Map<Integer, List<Integer>> cache;

    ChangeCalculator(List<Integer> currencyCoins) {
        this.coins = new ArrayList<>(currencyCoins);
        this.cache = new HashMap<>();
    }

    List<Integer> computeMostEfficientChange(int grandTotal) {

        if (grandTotal < 0) {
            throw new IllegalArgumentException("Negative totals are not allowed.");
        }

        List<Integer> r = computeChange(grandTotal);

        if (grandTotal != 0 && r.isEmpty()) {
            throw new IllegalArgumentException("The total " + grandTotal +
                    " cannot be represented in the given currency.");
        }

        return r;
    }

    private List<Integer> computeChange(int total) {

        if (total == 0) {
            return new ArrayList<>();
        }

        if (this.coins.contains(total)) {
            return List.of(total);
        }

        if (this.cache.containsKey(total)) {
            return this.cache.get(total);
        }

        List<Integer> bestSolution = new ArrayList<>();

        for (int coin : this.coins) {

            if (coin <= total) {
                List<Integer> sol = new ArrayList<>();
                sol.add(coin);
                sol.addAll(computeChange(total - coin));

                int sum = sol.stream().mapToInt(Integer::intValue).sum();

                if (sum == total 
                    && (bestSolution.size() == 0 || sol.size() < bestSolution.size())) {
                    bestSolution = new ArrayList<>();
                    bestSolution.addAll(sol);
                }
            }
        }

        this.cache.put(total, bestSolution);
        return bestSolution;
    }

}
