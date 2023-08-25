class Squares (val number: Int) {

    fun sumOfSquares() : Int {
        return (this.number * (this.number + 1) * (2 * this.number + 1)) / 6
    }

    fun squareOfSum() : Int {
        val sum = (this.number * (this.number + 1)) / 2
        return sum * sum
    }

    fun difference() : Int{
        return this.squareOfSum() - this.sumOfSquares()
    }
}
