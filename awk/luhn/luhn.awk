BEGIN {

    getline number < "-"

    gsub(" ", "", number)
    input_length = length(number)

    # tests the length of the string
    # and if it only contains numbers
    if ((match(number, /[^0-9]/)) || (input_length < 2)) {
        print "false"
    } else {
        total = 0

        split(number, numbers, "")

        for (i = input_length - 1; i > 0; i -= 2) {
            digit = numbers[i] * 2
            if (digit > 9) {
                numbers[i] = digit - 9
            } else {
                numbers[i] = digit
            }
        }

        for (i = 1; i <= input_length; i++) {
            total += numbers[i]
        }

        if (total % 10 == 0) {
            print "true"
        } else {
            print "false"
        }
    }

}
