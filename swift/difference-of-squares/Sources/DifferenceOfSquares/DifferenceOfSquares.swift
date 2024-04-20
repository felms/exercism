class Squares {

    let squareOfSum: Int
    let sumOfSquares: Int
    let differenceOfSquares: Int

    init(_ number: Int) {
        let sumOfNumbers = (number * (number + 1)) / 2
        self.squareOfSum = sumOfNumbers * sumOfNumbers
        self.sumOfSquares = (number * (number + 1) * (2 * number + 1)) / 6
        self.differenceOfSquares = self.squareOfSum - self.sumOfSquares
    }

}
