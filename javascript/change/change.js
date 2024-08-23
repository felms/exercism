export class Change {

    #cache;
    constructor() {
        this.#cache = {};
    }

    calculate(coinArray, target) {

        //for (let currentTarget = 0; currentTarget <= target; currentTarget++) {
        //    let sol = this.calculateChange(coinArray, currentTarget, [], Array(target));

        //    if (sol) {
        //        this.#cache[currentTarget] = sol;
        //    }
        //}

        //return this.#cache[target];

        return this.calculateChange(coinArray, target, [], Array(target + 1));

    }

    calculateChange(coinArray, target, currentSolution, bestSolution) {

        if (target === 0) {
            return currentSolution.length < bestSolution.length 
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
