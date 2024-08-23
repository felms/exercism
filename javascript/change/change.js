export class Change {

    #cache;
    constructor() {
        this.#cache = {};
    }

    calculate(coinArray, target) {

        return this.calculateChange(coinArray, target, [], null);
    }

    calculateChange(coinArray, target, currentSolution, bestSolution) {
        
        if (target === 0) {
            return (!bestSolution || currentSolution.length < bestSolution.length)
                ? currentSolution : bestSolution;
        }

        for (let coin of coinArray) {
            if (target - coin >= 0) {
                bestSolution = this.calculateChange(coinArray, target - coin, [...currentSolution, coin], bestSolution);
            }
        }

        return bestSolution;
    }

}
