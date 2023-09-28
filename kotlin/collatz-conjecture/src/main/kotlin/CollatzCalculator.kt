object CollatzCalculator {
    fun computeStepCount(start: Int): Int {

        require(start > 0)

        return when {
            start == 1 -> 0
            start % 2 == 0 -> 1 + computeStepCount(start / 2)
            else -> 1 + computeStepCount(3 * start + 1)
        }
    }
}
