import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        Signal[] signals = Signal.values();

        List<Signal> res = IntStream.range(0, signals.length)
                    .filter(i -> (number & (1 << i)) > 0)
                    .mapToObj(i -> signals[i])
                    .collect(Collectors.toList());

        if ((number & 0b10000) > 0) {
            Collections.reverse(res);
        }

        return res;
    }

}
