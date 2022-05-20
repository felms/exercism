import java.util.stream.IntStream;

public class NaturalNumber {

    private int number;

    public NaturalNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }

        this.number = number;

    }

    public Classification getClassification() {

        int alicotSum = IntStream.range(1, (this.number / 2) + 1)
                            .filter(factor -> this.number % factor == 0)
                            .sum();

        return alicotSum == this.number ? Classification.PERFECT
                             : alicotSum < this.number ? Classification.DEFICIENT : Classification.ABUNDANT;
    }
}
