import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordSearcher{

    public List<String> rows;
    public List<String> columns;
    public List<String> leftToBottonRDiagonal;

    public Map<String, Optional<WordLocation>> search(Set<String> searchWords, char[][] puzzle) {
        this.getRows(puzzle);
        this.getColumns(puzzle);
        this.getLeftToBottonRightDiagonal(puzzle);

        return searchWords.stream()
                .collect(Collectors.toMap(Function.identity(), this::searchWord));
    }

    // Procura pelas palavras
    private Optional<WordLocation> searchWord(String word) {
        Optional<WordLocation> rowsLocation = this.checkRows(word);
        Optional<WordLocation> columnsLocation = this.checkColumns(word);
        Optional<WordLocation> leftDiagonalLocation = this.checkLeftDiagonal(word);
        return rowsLocation.isPresent() ? rowsLocation
                : columnsLocation.isPresent() ? columnsLocation
                : leftDiagonalLocation;
    }

    // Procura pela palavra nas linhas
    private Optional<WordLocation> checkRows(String word) {

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

    // Procura pela palavra nas colunas
    private Optional<WordLocation> checkColumns(String word) {

        for (int i = 0; i < this.columns.size(); i++) {
            // Testa a palavra de cima pra baixo
            int x = this.columns.get(i).indexOf(word);
            if (x >= 0) {
                Pair start = new Pair(i + 1, x + 1);
                int x2 = x + word.length();
                Pair end = new Pair(i + 1, x2);
                return Optional.of(new WordLocation(start, end));
            }


            // Testa a palavra de baixo pra cima
            String wordReversed = new StringBuilder(word).reverse().toString();
            x = this.columns.get(i).indexOf(wordReversed);
            if (x >= 0) {
                Pair start = new Pair(i + 1, x + 1);
                int x2 = x + wordReversed.length();
                Pair end = new Pair(i + 1, x2);
                return Optional.of(new WordLocation(end, start));
            }
        }

        return Optional.empty();
    }

    // Procura pela palavra na diagonal
    // que vai do top esquerda até a direita
    private Optional<WordLocation> checkLeftDiagonal(String word) {

        // Testa a palavra no sentido correto
        for (int i = 0; i < this.rows.size(); i++) {

            List<String> row = Arrays.asList(this.rows.get(i).split(""));
            List<String> wordAsList = new ArrayList<>(Arrays.asList(word.split("")));
            String currentLetter = wordAsList.remove(0);
            if (row.contains(currentLetter)) {

                int pos = row.indexOf(currentLetter);
                Pair start = new Pair(i + 1, pos + 1);
                Pair end = new Pair(i + 1, pos + 1);
                int wordIter = i;
                while (!wordAsList.isEmpty()
                        && wordIter + wordAsList.size() < this.rows.size()
                        && pos + 1 < this.rows.size()) {
                    List<String> currentRow = Arrays.asList(this.rows.get(wordIter + 1).split(""));
                    currentLetter = wordAsList.remove(0);
                    if (currentLetter.equals(currentRow.get(pos + 1))) {
                       end = new Pair(wordIter + 2, pos + 2);
                    } else {
                        break;
                    }
                    wordIter++;
                    pos++;
                }

                if (wordAsList.isEmpty()) {
                    return Optional.of(new WordLocation(start, end));
                }

            }

        }

        // Testa a palavra ao contrário
        for (int i = 0; i < this.rows.size(); i++) {

            String wordReversed = new StringBuilder(word).reverse().toString();
            List<String> row = Arrays.asList(this.rows.get(i).split(""));
            List<String> wordAsList = new ArrayList<>(Arrays.asList(wordReversed.split("")));
            String currentLetter = wordAsList.remove(0);
            if (row.contains(currentLetter)) {

                int pos = row.indexOf(currentLetter);
                Pair start = new Pair(pos + 1, i + 1);
                Pair end = new Pair(pos + 1, i + 1);
                int wordIter = i;
                while (!wordAsList.isEmpty()
                        && wordIter + wordAsList.size() < this.rows.size()
                        && pos + 1 < this.rows.size()) {
                    List<String> currentRow = Arrays.asList(this.rows.get(wordIter + 1).split(""));
                    currentLetter = wordAsList.remove(0);
                    if (currentLetter.equals(currentRow.get(pos + 1))) {
                        end = new Pair(pos + 2, wordIter + 2);
                    } else {
                        break;
                    }
                    wordIter++;
                    pos++;
                }

                if (wordAsList.isEmpty()) {
                    return Optional.of(new WordLocation(end, start));
                }

            }

        }

        return Optional.empty();
    }

    // Preenche a lista das linhas
    public void getRows(char[][] puzzle) {
        this.rows = Arrays.stream(puzzle)
                .map(String::new)
                .collect(Collectors.toList());
    }

    // Preenche a lista das colunas
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

    // Preenche a diagonal do topo esquerda para 
    // baixo direita.
    public void getLeftToBottonRightDiagonal(char[][] puzzle) {
        this.leftToBottonRDiagonal = new ArrayList<>();

        // Crio uma lista das linhas
        List<StringBuilder> list = Arrays.stream(puzzle)
                .map(String::new)
                .map(StringBuilder::new)
                .collect(Collectors.toList());

        // Coloco um padding em todas as palavras para
        // poder retirar apenas os trechos necessários;
        int newSize = puzzle.length * 2 - 1;
        int prependSize = puzzle.length - 1;
        int appendSize = 0;
        while (prependSize >= 0) {

            StringBuilder sb = list.get(appendSize);
            while (sb.length() < puzzle.length + prependSize) {
                sb.insert(0, " ");
            }

            while (sb.length() < newSize) {
                sb.append(" ");
            }
            prependSize--;
            appendSize++;
        }

        // Crio uma nova list com as palavras formadas pelas colunas
        // das palavras com o padding
        List<String> diagonalColumns = new ArrayList<>();
        for (int j = 0; j < newSize; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < puzzle.length; i++) {
                sb.append(list.get(i).charAt(j));
            }
            diagonalColumns.add(sb.toString());
        }

        this.leftToBottonRDiagonal.addAll(diagonalColumns
                .stream()
                .map(String::trim)
                .collect(Collectors.toList())
        );
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
        wordSearcher.getLeftToBottonRightDiagonal(puzzle);

        System.out.println(wordSearcher.rows);
        System.out.println(wordSearcher.columns);
        System.out.println(wordSearcher.leftToBottonRDiagonal);
    }
}
