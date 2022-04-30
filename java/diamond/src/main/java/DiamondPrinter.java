import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {
        List<String> list = new ArrayList<>();
        int size = (a - 'A') * 2 + 1;

        char currentChar = 'A';
        while(list.size() < size) {
            list.add(getLine(currentChar, size));

            if (list.size() > (size / 2)) {
                currentChar--;
            } else {
                currentChar++;
            }
        }

        return list;
    }

    public String getLine(char currentChar, int stringSize) {
        StringBuilder sb = new StringBuilder();

        int middle = stringSize / 2;
        int diff = currentChar - 'A';

        for (int i = 0; i < stringSize; i++) {
            if (i == middle - diff || i == middle + diff) {
                sb.append(currentChar);
            } else {
                sb.append(' ');
            }
        }

        return sb.toString();
    }
}