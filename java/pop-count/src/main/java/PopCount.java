public class PopCount {
    public int eggCount(int number) {
        int count = 0;

        while (number > 0) {
            count += number & 1;
            number = number >> 1;
        }

        return count;
    }
}
