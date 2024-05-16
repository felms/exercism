class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sumOfNumbers = (input * (input + 1)) / 2;
        return sumOfNumbers * sumOfNumbers;
    }

    int computeSumOfSquaresTo(int input) {
        return (input * (input + 1) * (2 * input + 1)) / 6;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
