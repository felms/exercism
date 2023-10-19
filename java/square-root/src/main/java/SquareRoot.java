public class SquareRoot {
    public int squareRoot(int radicand) {

        // Repeated subtraction method
        int currentOddNumber = 1;
        int counter = 0;

        while (radicand >= currentOddNumber) {
            radicand -= currentOddNumber;
            currentOddNumber += 2;
            counter++;
        }

        return counter;
    }
}
