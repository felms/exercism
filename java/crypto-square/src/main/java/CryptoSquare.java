import java.util.ArrayList;
import java.util.List;

public class CryptoSquare {

    private final String normalizedInput;
    private final int columns;
    private final int rows;

    public CryptoSquare(String inputText) {

        this.normalizedInput = inputText.toLowerCase().replaceAll("\\W", "");
        this.columns = this.getNumberOfColumns(); 
        this.rows = this.getNumberOfRows();

    }

    public String getCiphertext() {

        if (this.normalizedInput.length() == 0) {
            return "";
        }

        // Adding padding to the string
        StringBuilder text = new StringBuilder(this.normalizedInput);
        while (text.length() < this.rows * this.columns) {
            text.append(" ");
        }

        // Dividing the string in equal sized chunks
        List<String> chunks = new ArrayList<>();

        int begin = 0;
        int end = this.columns;

        while (end <= text.length()) {
            chunks.add(text.substring(begin, end));
            begin += this.columns;
            end += this.columns;
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

        return String.join(" ", esList);
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

