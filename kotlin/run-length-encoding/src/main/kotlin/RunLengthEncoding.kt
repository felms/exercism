object RunLengthEncoding {

    fun encode(input: String): String =
        input.replace("(.)\\1+".toRegex()) { "${it.value.length}${it.groupValues[1]}" }

    fun decode(input: String): String =
        input.replace("(\\d+)(.)".toRegex()) { it.groupValues[2].repeat(it.groupValues[1].toInt()) }
}
