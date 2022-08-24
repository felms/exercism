import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpticalCharacterReader{

    private final Map<String, String> ocr;

    public OpticalCharacterReader() {

        this.ocr = new HashMap<>();
        this.ocr.put(" _ | ||_|   ", "0"); // zero
        this.ocr.put("     |  |   ", "1"); // one
        this.ocr.put(" _  _||_    ", "2"); // two
        this.ocr.put(" _  _| _|   ", "3"); // three
        this.ocr.put("   |_|  |   ", "4"); // four
        this.ocr.put(" _ |_  _|   ", "5"); // five
        this.ocr.put(" _ |_ |_|   ", "6"); // six
        this.ocr.put(" _   |  |   ", "7"); // seven
        this.ocr.put(" _ |_||_|   ", "8"); // eight
        this.ocr.put(" _ |_| _|   ", "9"); // nine

    }

    public String parse(List<String> input) {

        if (input.size() % 4 != 0) {
            throw new IllegalArgumentException("Number of input rows must be a positive multiple of 4");
        }

        if (input.get(0).length() % 3 != 0) {
            throw new IllegalArgumentException("Number of input columns must be a positive multiple of 3");
        }


        int columns = input.get(0).length();
        int rows = input.size();
        int gRows = rows / 4;
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < gRows; k++) {

            List<String> letters = new ArrayList<>();
            for (int j = 0; j < columns; j += 3) {
                StringBuilder number = new StringBuilder();
                for (int i = k * 4; i < (k + 1) * 4; i++) {
                    String s = input.get(i);
                    number.append(s, j, j + 3);
                }
                letters.add(number.toString());
            }

            letters.forEach(letter -> sb.append(this.ocr.getOrDefault(letter, "?")));
            sb.append(",");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

}