import java.util.ArrayList; import java.util.List;

public class KillerSudokuHelper {

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize, List<Integer> exclude) {
        List<List<Integer>> possibleCombinations = combinationsInCage(cageSum, cageSize);

        return possibleCombinations.stream()
                .filter(combination -> !combination.stream().anyMatch(number -> exclude.contains(number)))
                .toList();
    }

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize) {
        List<List<Integer>> combinationsList = new ArrayList<>();
        combinationsInCage(combinationsList, new ArrayList<>(), cageSum, cageSize);
        return combinationsList;
    }
    
    void combinationsInCage(List<List<Integer>> combinations, List<Integer> currentList, Integer targetSum, int cageSize) {
        int currentSize = currentList.size();
        if (targetSum == 0 && currentSize == cageSize) {
            combinations.add(new ArrayList<>(currentList));
            return;
        }

        if (targetSum <= 0 || currentSize > cageSize) {
            return;
        }

        int first = currentSize > 0 ? currentList.get(currentSize - 1) + 1 : 1;
        for (int i = first; i <= targetSum; i++) {
            currentList.add(i);
            combinationsInCage(combinations, currentList, targetSum - i, cageSize);
            currentList.remove(currentList.size() - 1);
        }

    }

}
