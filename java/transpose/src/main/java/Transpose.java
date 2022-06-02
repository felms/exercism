import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Transpose {

    public String transpose(String string) {

        if ("".equals(string)) {
            return "";
        }

        List<List<String>> matrix = Arrays.asList(string.split(System.lineSeparator()))
                .stream()
                .map(item -> Arrays.asList(item.split("")))
                .collect(Collectors.toList());

        int maxSize = matrix.stream()
                .mapToInt(item -> item.size())
                .max().orElse(0);
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < maxSize; i++) {
            sb.append(getColumn(matrix, i));
        }

        
        return sb.toString().trim();
    }

    public String getColumn(List<List<String>> matrix, int column) {

        StringBuilder sb = new StringBuilder();        
        
        for (int i = 0; i < matrix.size(); i++) {
            List<String> list = matrix.get(i);
            String s = list.size() > column ? list.get(column) : " ";
            sb.append(s);
        }

        sb.append("\n");

        return sb.toString();
    }

}