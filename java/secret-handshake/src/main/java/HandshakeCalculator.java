import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> list = new ArrayList<>();
        int n = number;
        n = decToBin(n);

        if(n % 10 != 0) {
            list.add(Signal.WINK);
            n -= 1;
        }

        if (n % 100 != 0) {
            list.add((Signal.DOUBLE_BLINK));
            n -= 10;
        }

        if (n % 1000 != 0) {
            list.add(Signal.CLOSE_YOUR_EYES);
            n -= 100;
        }

        if (n % 10000 != 0) {
            list.add(Signal.JUMP);
            n -= 1000;
        }

        if (n % 100000 != 0) {
            Collections.reverse(list);
        }

        return list;
    }

    private int decToBin(int number) {
        int n = number;
        int result = 0;
        int count = 0;
        while(n > 0) {
            int r = n % 2;
            n -= r;
            n /= 2;
            result = ((int)Math.pow(10, count) * r) + result;
            count++;
        }

        return result;
    }

    public static void main(String[] args) {
        List<Signal> list = new HandshakeCalculator().calculateHandshake(Integer.parseInt(args[0]));
        list.forEach(System.out::println);
    }

}
