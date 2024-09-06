import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class DiamondPrinter {

    List<String> printToList(char a) {


        int size = (a - 'A') * 2;
        List<String> res = new ArrayList<>();
        int delta = size / 2;


        for (int i = 0; i <= delta; i++) {
            char currentLetter = (char) ('A' + i);
            char[] str = new char[size + 1];
            Arrays.fill(str, ' ');

            str[delta - i] = currentLetter;
            str[delta + i] = currentLetter;

            res.add(new String(str));
        }

        List<String> secondHalf = new ArrayList(res.subList(0, delta));
        Collections.reverse(secondHalf);
        res.addAll(secondHalf);

        return res;
    }

}
