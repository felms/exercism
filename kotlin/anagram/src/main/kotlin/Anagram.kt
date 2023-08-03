class Anagram (val word : String) {

    fun match(anagrams: Collection<String>): Set<String> {

        val sortedWord = this.word.lowercase().split("").sorted().joinToString("")
        var result = mutableSetOf<String>()

        for (candidate in anagrams) {
            val sorted = candidate.lowercase().split("").sorted().joinToString("")
            if ((word.lowercase() != candidate.lowercase()) && sorted == sortedWord)  {
                result.add(candidate)
            }
        }

        return result
    }
}
