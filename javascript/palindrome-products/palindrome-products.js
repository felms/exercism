export class Palindromes {

    static generate(range) {

        let {maxFactor, minFactor} = range;

        if (minFactor > maxFactor) {
            throw new Error('min must be <= max');
        }

        let palindromeProducts = [];

        for (let i = minFactor; i <= maxFactor; i++) {
            for (let j = i; j <= maxFactor; j++) {
                let productFactors = [i, j];
                let product = i * j;

                if (Palindromes.isPalindrome(product)) {

                    let pos = palindromeProducts.findIndex(item => {
                            return item.value === product;
                            });
                    if (pos >= 0) {
                        let productEntry = palindromeProducts[pos];
                        productEntry.factors.push(productFactors);
                    } else {
                        let productEntry = {value: product, factors: [productFactors]}
                        palindromeProducts.push(productEntry);
                    }

                }
            }
        }

        palindromeProducts.sort((a, b) => a.value - b.value);

        let first = palindromeProducts[0] 
            ? palindromeProducts[0] 
            : {value: null, factors: []};

        let last = palindromeProducts[palindromeProducts.length - 1] 
            ? palindromeProducts[palindromeProducts.length - 1] 
            : {value: null, factors: []}

        return {smallest : first, largest: last};

    }

    static isPalindrome(number) {

        // Transforma o número para string
        let string = number.toString();

        // Itera sobre a primeira metade da string
        for (let i = 0; i < string.length / 2; i++) {

            // Checa se os itens 'espelhados' nas duas
            // metades da string são iguais
            if (string[i] !== string[string.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

}
