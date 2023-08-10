object ScrabbleScore {

    fun scoreLetter(c: Char): Int {
        return when(c) {
            in "AEIOULNRST" -> 1 
            in "DG"         -> 2 
            in "BCMP"       -> 3 
            in "FHVWY"      -> 4
            'K'             -> 5
            in "JX"         -> 8
            in "QZ"         -> 10
            else            -> 0
        }
    }

    fun scoreWord(word: String): Int {
        return word.uppercase().sumOf{it -> scoreLetter(it)}
    }
}
