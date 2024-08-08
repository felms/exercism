export class HighScores {

    #scoresList;

    constructor(scores) {
        this.#scoresList = [...scores];
    }

    get scores() {
        return this.#scoresList;
    }

    get latest() {
        return this.#scoresList[this.#scoresList.length - 1];
    }

    get personalBest() {
        return Math.max(...this.#scoresList);
    }

    get personalTopThree() {
        return this.#scoresList.toSorted((a, b) => b - a).slice(0, 3);
    }
}
