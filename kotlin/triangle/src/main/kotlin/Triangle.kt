class Triangle<out T : Number> (val a: T, val b: T, val c: T) {

    init {

        val dA: Double = a.toDouble()
        val dB: Double = b.toDouble()
        val dC: Double = c.toDouble()

        require (dA + dB > dC)
        require (dA + dC > dB)
        require (dB + dC > dA)
        require (dA > 0 && dB > 0 && dC > 0)

    }

    val isEquilateral: Boolean = a == b && b == c
    val isIsosceles: Boolean = a == b || a == c || b == c
    val isScalene: Boolean = a != b && a != c && b != c


}
