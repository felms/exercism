import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Transpose {

    private List<List<String>> matrix;

    public String transpose(String inputString) {

        if ("".equals(inputString)) {
            return "";
        }

        // Cria uma matriz com as strings
        this.matrix = Arrays.stream(inputString.split(System.lineSeparator()))
                .map(row -> Arrays.stream(row.split("")).collect(Collectors.toList()))
                .collect(Collectors.toList());

        // Retorna o tamanho da maior string do array
        int maxSize = this.matrix.stream().map(List::size)
                .max(Integer::compare).orElseThrow();

        // Deixa todas as linhas da matriz do mesmo tamanho
        this.padRows(maxSize);
        List<String> transposed = new ArrayList<>();

        // "Transpõe" a matriz
        for (int i = 0; i < maxSize; i++) {
            transposed.add(String.join("", this.getColumn(i)));
        }

        // Remove o "padding" da string. Gambiarra das brabas
        for (int i = transposed.size() - 1; i >= 0; i--) {
            // remove o "padding" do fim
            String str = transposed.get(i).replaceAll("#+$", "");

            // remove o "padding" do meio da string
            str = str.replaceAll("#", " ");
            
            transposed.set(i, str);
        }

        return String.join("\n", transposed).trim();
    }

    private List<String> getColumn(int column) {
        return this.matrix.stream().map(row -> row.get(column))
                .collect(Collectors.toList());
    }

    private void padRows(int padTo) {

        this.matrix.forEach(item -> {
                    while (item.size() < padTo) {
                        item.add("#");
                    }
                });
    }

}
