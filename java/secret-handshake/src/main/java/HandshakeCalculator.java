import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {

        List<Signal> res = new ArrayList<>();

        for (Signal s : Signal.values()) {
            if (((number >> s.ordinal()) & 1) == 1) {
                res.add(s);
            }
        }

        if (((number >> 4) & 1) == 1) {
            Collections.reverse(res);
        }

        return res;
    }

}
