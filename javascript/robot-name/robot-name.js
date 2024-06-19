const ALPHABET = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
const usedNames = new Set();

export class Robot {
    #name;

    constructor() {
        this.#name = this.#generateName();
    }

    get name() {
        return this.#name;
    }

    reset() {
        this.#name = this.#generateName();
    }

    #generateName() {
        let newName = '';

        do {

            let letters = ALPHABET[Math.floor(Math.random() * 26)] 
                + ALPHABET[Math.floor(Math.random() * 26)];

            newName = `${letters}${100 + Math.floor(Math.random() * 900)}`;
        } while (usedNames.has(newName));

        usedNames.add(newName);
        return newName;
    }

}


Robot.releaseNames = () => usedNames.clear();
