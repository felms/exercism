import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CryptoSquare {

    private String normalizedInput;
    private int columns;
    private int rows;

    public CryptoSquare(String inputText) {

        this.normalizedInput = inputText.toLowerCase().replaceAll("[^\\w]", "");
        this.columns = this.getNumberOfColumns(); 
        this.rows = this.getNumberOfRows();

    }

    public String getCiphertext() {

        if (this.normalizedInput.length() == 0) {
            return "";
        }

        // Adding padding to the string
        String text = this.normalizedInput;
        while (text.length() < this.rows * this.columns) {
            text += " ";
        }

        // Dividing the string in equal sized chunks
        List<String> chunks = new ArrayList<>();

        int begin = 0;
        int end = this.rows;

        while (end <= text.length()) {
            chunks.add(text.substring(begin, end));
            begin += this.rows;
            end += this.rows;
        }

        // Create the encoded string
        List<String> esList = new ArrayList<>();
        for (int j = 0; j < this.columns; j++) {
            StringBuilder cString = new StringBuilder();
            for (int i = 0; i < this.rows; i++) {
                char c = chunks.get(i).charAt(j);
                cString.append(c);
            }
            esList.add(cString.toString());
        }

        return esList.stream().collect(Collectors.joining(" "));
    }

    private int getNumberOfColumns() {

        int stringSize = this.normalizedInput.length();
        int i = 1;
        while (i * i < stringSize) {
            i++;
        }

        return i;
    }

    private int getNumberOfRows() {

        int i = this.columns - 1;
        int stringSize = this.normalizedInput.length();
        return i * this.columns >= stringSize ? i : this.columns;
    }

}

