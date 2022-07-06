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

    public Map<String, Optional<WordLocation>> search(Set<String> searchWords, char[][] puzzle) {
        this.getRows(puzzle);
        this.getColumns(puzzle);

        return searchWords.stream()
                .collect(Collectors.toMap(Function.identity(), this::searchWord));
    }

    // Procura pelas palavras
    private Optional<WordLocation> searchWord(String word) {
        Optional<WordLocation> rowsLocation = this.checkRows(word);
        Optional<WordLocation> columnsLocation = this.checkColumns(word);
        Optional<WordLocation> leftDiagonalLocation = this.checkLeftDiagonal(word);
        Optional<WordLocation> rightDiagonalLocation = this.checkRightDiagonal(word);
        return rowsLocation.isPresent() ? rowsLocation
                : columnsLocation.isPresent() ? columnsLocation
                : leftDiagonalLocation.isPresent() ? leftDiagonalLocation
                : rightDiagonalLocation;
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
                int y = x + word.length();
                Pair end = new Pair(i + 1, y);
                return Optional.of(new WordLocation(start, end));
            }


            // Testa a palavra de baixo pra cima
            String wordReversed = new StringBuilder(word).reverse().toString();
            x = this.columns.get(i).indexOf(wordReversed);
            if (x >= 0) {
                Pair start = new Pair(i + 1, x + 1);
                int y = x + wordReversed.length();
                Pair end = new Pair(i + 1, y);
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

    // Procura pela palavra na diagonal
    // que vai do top direira até a esquerda
    private Optional<WordLocation> checkRightDiagonal(String word) {

        // Testa a palavra ao contrário
        for (int i = 0; i < this.rows.size(); i++) {

            List<String> row = Arrays.asList(this.rows.get(i).split(""));
            String wordReversed = new StringBuilder(word).reverse().toString();
            List<String> wordAsList = new ArrayList<>(Arrays.asList(wordReversed.split("")));
            String currentLetter = wordAsList.remove(0);
            if (row.contains(currentLetter)) {

                int pos = row.indexOf(currentLetter);
                Pair start = new Pair(i + 1, pos + 1);
                Pair end = new Pair(i + 1, pos + 1);
                int wordIter = i;
                while (!wordAsList.isEmpty()
                        && wordIter + wordAsList.size() < this.rows.size()
                        && pos - 1 > 0) {
                    List<String> currentRow = Arrays.asList(this.rows.get(wordIter + 1).split(""));
                    currentLetter = wordAsList.remove(0);
                    if (currentLetter.equals(currentRow.get(pos - 1))) {
                        end = new Pair(wordIter + 2, pos);
                    } else {
                        break;
                    }
                    wordIter++;
                    pos--;
                }

                if (wordAsList.isEmpty()) {
                    return Optional.of(new WordLocation(start, end));
                }

            }

        }

        // Testa a palavra no sentido correto
        for (int i = 0; i < this.rows.size(); i++) {

            List<String> row = Arrays.asList(this.rows.get(i).split(""));
            List<String> wordAsList = new ArrayList<>(Arrays.asList(word.split("")));
            String currentLetter = wordAsList.remove(0);
            if (row.contains(currentLetter)) {

                int pos = row.indexOf(currentLetter);
                Pair start = new Pair(pos + 1, i + 1);
                Pair end = new Pair(pos + 1, i + 1);
                int wordIter = i;
                while (!wordAsList.isEmpty()
                        && wordIter + wordAsList.size() < this.rows.size()
                        && pos - 1 > 0) {
                    List<String> currentRow = Arrays.asList(this.rows.get(wordIter + 1).split(""));
                    currentLetter = wordAsList.remove(0);
                    if (currentLetter.equals(currentRow.get(pos - 1))) {
                        end = new Pair(pos, wordIter + 2);
                    } else {
                        break;
                    }
                    wordIter++;
                    pos--;
                }

                if (wordAsList.isEmpty()) {
                    return Optional.of(new WordLocation(start, end));
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
            for (char[] chars : puzzle) {
                sb.append(chars[j]);
            }
            this.columns.add(sb.toString());
        }
    }

}
