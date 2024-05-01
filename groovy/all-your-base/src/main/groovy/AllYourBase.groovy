class AllYourBase {

    int inputBase;
    def digits;

    AllYourBase(inputBase, digits) {
        this.inputBase = inputBase;
        this.digits = digits;
    }

    def rebase(outputBase) {

        if (inputBase < 2 || outputBase < 2) {
            throw new ArithmeticException();
        }

        // --- Convert do base 10

        int numberInBase10 = 0;
        int inputLength = this.digits.size();

        for (int i = inputLength - 1; i >= 0; i--) { 
            if (this.digits[i] < 0 || this.digits[i] >= inputBase) {
                throw new ArithmeticException();
            }

            numberInBase10 += this.digits[i] * Math.pow(this.inputBase, inputLength - i - 1);
        }

        if (this.digits.isEmpty() || numberInBase10 == 0) {
            return [0];
        }

        // --- Convert from decimal to 'outputBase'

        int outputPos = 0;
        def outputDigits = [];

        while (numberInBase10 > 0) {
            outputDigits.add(numberInBase10 % outputBase);
            numberInBase10 /= outputBase;
        }

        return outputDigits.reverse();
    }

}
