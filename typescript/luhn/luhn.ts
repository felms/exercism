export function valid(digitString: String): Boolean {

    let string = digitString.replace(/\s+/g, "");

    if (string.length < 2) {
        return false;
    }

    let sum = [...string]
                .map(Number).reverse()
                .reduce((sum, digit, index) => 
                    index % 2 === 0
                        ? sum + digit 
                        : (digit * 2) > 9 
                        ? sum + ((digit * 2) - 9) 
                        : sum + (digit * 2), 
                0);

    return sum % 10 === 0;
}
