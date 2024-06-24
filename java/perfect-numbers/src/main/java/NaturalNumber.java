import java.util.stream.IntStream;

class NaturalNumber {

    private int number;

    NaturalNumber(int number) {

        if (number < 1) {
            throw new IllegalArgumentException(
                "You must supply a natural number (positive integer)");
        }

        this.number = number;
    }

    Classification getClassification() {
        int sum = this.aliquotSum();
        return sum == this.number ? Classification.PERFECT 
                        : sum > this.number ? Classification.ABUNDANT
                        : Classification.DEFICIENT;
    }

    private int aliquotSum() {
        return IntStream.range(1, (this.number) / 2 + 1)
                .filter(n -> this.number % n == 0).sum();
    }
}
