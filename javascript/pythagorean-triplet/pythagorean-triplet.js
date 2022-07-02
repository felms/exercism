export function triplets({ minFactor, maxFactor, sum }) {
    let tripletsList = [];

    let min = minFactor ? minFactor : 1;
    let max = maxFactor ? maxFactor : sum; 

    for (let a = min; a < max; a++) {
        for (let b = min; b < max; b++) {
            let c = sum - a - b;

            let a2 = a ** 2;
            let b2 = b ** 2;
            let c2 = c ** 2;

            if (c >= min && c <= max
                    && a + b + c === sum
                    && a < b && b < c
                    && a2 + b2 === c2){
                tripletsList.push(new Triplet(a, b, c));
            }
        }
    }

    return tripletsList;
}

class Triplet {
    constructor(a, b, c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    toArray() {
        return [this.a, this.b, this.c];
    }
}
