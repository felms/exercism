class PhoneNumber {

    var number: String?

    constructor (inputNumber: String) {
        val cleanedNumber: String = inputNumber.replace("\\D".toRegex(), "")

        if (!(cleanedNumber.matches(Regex("^1?[2-9]\\d{2}[2-9]\\d{6}")))) {
            throw IllegalArgumentException()
        }

        number = if (cleanedNumber.length == 11) { 
            cleanedNumber.substring(1) 
        } else { 
            cleanedNumber
        }

    }
}
