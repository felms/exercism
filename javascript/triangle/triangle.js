export class Triangle {

    #sideA;
    #sideB;
    #sideC;

    constructor(sideA, sideB, sideC) {
        this.#sideA = sideA;
        this.#sideB = sideB;
        this.#sideC = sideC;
    }

    get isEquilateral() {
        return this.#isTriangle() && this.#sideA === this.#sideB 
                                && this.#sideB === this.#sideC;
    }

    get isIsosceles() {
        return this.#isTriangle() && (this.#sideA === this.#sideB 
                || this.#sideB === this.#sideC || this.#sideA === this.#sideC);
    }

    get isScalene() {
        return this.#isTriangle() 
                && (this.#sideA !== this.#sideB 
                    && this.#sideA !== this.#sideC 
                    && this.#sideB !== this.#sideC);
    }

    #isTriangle() {
        return this.#sideA > 0 && this.#sideB > 0 && this.#sideC > 0
                    && ((this.#sideA + this.#sideB >= this.#sideC) &&
                        (this.#sideB + this.#sideC >= this.#sideA) &&
                        (this.#sideA + this.#sideC >= this.#sideB)); 
    }
}
