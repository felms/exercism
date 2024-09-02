export class Palindromes {
    static generate({maxFactor, minFactor}) {

        if (minFactor > maxFactor) {
            throw new Error('min must be <= max');
        }

        let minProd = minFactor * minFactor;
        let maxProd = maxFactor * maxFactor;

        let allPossibleFactors = Array.from(new Array(maxFactor + 1 - minFactor), (x, i) => i + minFactor);
        let palindromesInRange = 
                Array.from(new Array(maxProd + 1 - minProd), (x, i) => i + minProd) 
                .filter(num => Palindromes.isPalindrome(i));

        let smallest = {value: null, factors: []};
        let largest = {value: null, factors: []};

        for (let i = 0; i < palindromesInRange.length; i++) {
            let candidate = palindromesInRange[i];
            
        }
    
        return {
            smallest: smallest,
            largest: largest
        };

    }

    static isPalindrome(number) {

        if (number > 0 && number < 10) {
            return true;
        }

        let n = number;
        let rev = 0;

        while (n > 0) {
            rev *= 10;
            rev += n % 10;
            n = Math.floor(n / 10);
        }

        return rev === number;
    }

}
