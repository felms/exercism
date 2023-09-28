fun transcribeToRna(dna: String): String = dna.split("").map{
    when(it) { 
        "G" -> "C" 
        "C" -> "G" 
        "T" -> "A" 
        "A" -> "U" 
        else -> "" 
    }
}.joinToString("")
