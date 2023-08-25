object Raindrops {

    fun convert(n: Int): String {
        var res: String = ""

        if (n % 3 == 0) {
            res += "Pling"
        }

        if (n % 5 == 0) {
            res += "Plang"
        }

        if (n % 7 == 0) {
            res += "Plong"
        }

        return if (res == "") {
            n.toString()
        } else {
            res
        }

    }
}
