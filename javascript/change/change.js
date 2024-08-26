export class Change {

    #cache;
    constructor() {
        this.#cache = {};
    }

    calculate(coinArray, target) {

        let r = this.calculateChange(coinArray, target);
        return r;
    }

    calculateChange(coinArray, target) {

        if (target === 0) {
            return [];
        }

        if (coinArray.includes(target)) {
            return [target];
        }

        let bestSolution = [];

        for (let coin of coinArray) {
            if (coin <= target) {
                let sol = [coin, ...this.calculateChange(coinArray, target - coin)];
                let solSum = sol.reduce((a, b) => a + b);

                if (solSum === target 
                        && (bestSolution.length === 0 || sol.length < bestSolution.length)) {
                    bestSolution = [...sol];
                }
            }
        }

        return bestSolution;
    }

}
