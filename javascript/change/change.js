export class Change {

    #cache;
    constructor() {
        this.#cache = {};
    }

    calculate(coinArray, target) {

        if (target < 0) {
            throw new Error('Negative totals are not allowed.');
        }

        let r = this.calculateChange(coinArray, target);

        if (target !== 0 && r.length === 0) {
            throw new Error(`The total ${target} cannot be represented in the given currency.`);
        }

        return r;
    }

    calculateChange(coinArray, target) {

        if (target === 0) {
            return [];
        }

        if (coinArray.includes(target)) {
            return [target];
        }

        if (this.#cache[target]) {
            return this.#cache[target];
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

        this.#cache[target] = bestSolution;

        return bestSolution;
    }

}
