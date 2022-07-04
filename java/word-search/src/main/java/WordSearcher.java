import java.util.*;
import java.util.stream.Collectors;

public class WordSearcher{

    public List<String> rows;
    public List<String> columns;

    public Map<String, Optional<WordLocation>> search(Set<String> searchWords, char[][] puzzle) {
        this.getRows(puzzle);
        this.getColumns(puzzle);
        Map<String, Optional<WordLocation>> searchResults = new HashMap<>();

        searchWords.forEach(word -> searchResults.put(word, checkrows(word)));

        return searchResults;
    }

    private Optional<WordLocation> checkrows(String word) {

        for (int i = 0; i < this.rows.size(); i++) {
            // Testa a palavra no sentido correto
            int x = this.rows.get(i).indexOf(word);
            if (x >= 0) {
                Pair start = new Pair(x + 1,  i + 1);
                int x2 = x + word.length();
                Pair end = new Pair(x2, i + 1);
                return Optional.of(new WordLocation(start, end));
            }

            // Testa a palavra ao contrário
            String wordReversed = new StringBuilder(word).reverse().toString();
            x = this.rows.get(i).indexOf(wordReversed);
            if (x >= 0) {
                Pair start = new Pair(x + 1, i + 1);
                int x2 = x + wordReversed.length();
                Pair end = new Pair(x2, i + 1);
                return Optional.of(new WordLocation(end, start));
            }
        }
        return Optional.empty();
    }

    public void getRows(char[][] puzzle) {
        this.rows = Arrays.stream(puzzle)
                .map(String::new)
                .collect(Collectors.toList());
    }

    public void getColumns(char[][] puzzle) {
        this.columns = new ArrayList<>();
        for (int j = 0; j < puzzle[0].length; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < puzzle.length; i++) {
                sb.append(puzzle[i][j]);
            }
            this.columns.add(sb.toString());
        }
    }

    private Optional<WordLocation> searchWord(String word) {

        return Optional.empty(); // TODO change this
    }

    public static void main(String[] args) {
        WordSearcher wordSearcher = new WordSearcher();
        char[][] puzzle = new char[][]{
                {'j', 'e', 'f', 'b', 'l', 'p', 'e', 'p', 'r', 'e'},
                {'c', 'a', 'm', 'd', 'c', 'i', 'm', 'g', 't', 'c'},
                {'o', 'i', 'v', 'o', 'k', 'p', 'r', 'j', 's', 'm'},
                {'p', 'b', 'w', 'a', 's', 'q', 'r', 'o', 'u', 'a'},
                {'r', 'i', 'x', 'i', 'l', 'e', 'l', 'h', 'r', 's'},
                {'w', 'o', 'l', 'c', 'q', 'l', 'i', 'r', 'p', 'c'},
                {'s', 'c', 'r', 'e', 'e', 'a', 'u', 'm', 'g', 'r'},
                {'a', 'l', 'x', 'h', 'p', 'b', 'u', 'r', 'y', 'i'},
                {'j', 'a', 'l', 'a', 'y', 'c', 'a', 'l', 'm', 'p'},
                {'c', 'l', 'o', 'j', 'u', 'r', 'e', 'r', 'm', 't'}
        };
        wordSearcher.getRows(puzzle);
        wordSearcher.getColumns(puzzle);

        System.out.println(wordSearcher.rows);
        System.out.println(wordSearcher.columns);
    }
}
