class Anagram (val word : String) {

    fun match(anagrams: Collection<String>): Set<String> {

        val sortedWord = word.lowercase().split("").sorted().joinToString("")

        return anagrams.filter { 
            it.lowercase().split("").sorted().joinToString("") == sortedWord
                && it.lowercase() != word.lowercase()
        }.toSet()
    }
}
