class RotationalCipher (val shift : Int) {

    fun encode(text: String): String {
        return text.map {
            when (it) {
                in 'a'..'z' -> 'a' + (it - 'a' + shift) % 26
                in 'A'..'Z' -> 'A' + (it - 'A' + shift) % 26
                else -> it
            
            }
        }.joinToString("")
    }
}
