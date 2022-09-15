import java.util.*;
import java.util.stream.Collectors;

public class Alphametics {

    private final Puzzle puzzle;
    private Map<Character, Integer> solution;
    private final List<Character> letters;

    public Alphametics(String puzzle) {

        String[] equation = puzzle.split(" == ");
        this.puzzle = new Puzzle(Arrays.asList(equation[0].split(" \\+ ")), equation[1]);
        this.solution = new HashMap<>();
        this.letters = puzzle.replaceAll("[^A-Z]", "").chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(this);
    }

    public Map<Character, Integer> solve() throws UnsolvablePuzzleException {

        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));

        if (solvePuzzle(new HashMap<>(), numbers)) {
            return this.solution;
        } else {
            throw new UnsolvablePuzzleException();
        }

    }

    private boolean solvePuzzle(Map<Character, Integer> currentSolution,
                                List<Integer> remainingNumbers) {

        if (this.letters.isEmpty()) {
            if (validSolution(this.puzzle, currentSolution)) {
                this.solution = new HashMap<>(currentSolution);
                return true;
            }

            return false;
        }

        Map<Character, Integer> newSolution = new HashMap<>(currentSolution);
        char currentLetter = this.letters.remove(0);
        int size = remainingNumbers.size();
        for (int i = 0; i < size; i++) {

            int currentNumber = remainingNumbers.remove(i);
            newSolution.put(currentLetter, currentNumber);

            if (solvePuzzle(newSolution, remainingNumbers)) {
                return true;
            } else {
                remainingNumbers.add(i, currentNumber);
                newSolution.remove(currentLetter);
            }

        }

        this.letters.add(0, currentLetter);

        return false;
    }

    private boolean validSolution(Puzzle puzzle, Map<Character, Integer> solution) {

        List<String> lS = puzzle.operands().stream()
                .map(number -> this.wordToNumber(number, solution)).toList();

        if (lS.stream().anyMatch(number -> number.charAt(0) == '0')) { // Testa para leading 0
            return false;
        }

        long leftSide = lS.stream()
                .map(Long::parseLong)
                .mapToLong(Long::longValue)
                .sum();

        String rS = this.wordToNumber(puzzle.result(), solution);
        if (rS.charAt(0) == '0') { // Testa para leading 0
            return false;
        }

        long rightSize = Long.parseLong(rS);

        return leftSide == rightSize;
    }

    private String wordToNumber(String word, Map<Character, Integer> mapping) {
        return word.chars()
                .mapToObj(i -> (char) i)
                .map(c -> mapping.get(c).toString())
                .collect(Collectors.joining());
    }

}