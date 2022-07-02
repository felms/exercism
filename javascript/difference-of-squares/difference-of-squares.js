export class Squares {
    constructor(n) {
        this.n = n;
    }

    get sumOfSquares() {
        let sum = 0;

        for (let i = 1; i <= this.n; i++) {
            sum += i * i;        
        } 

        return sum;
    }

    get squareOfSum() {
        let sum = 0;

        for (let i = 1; i <= this.n; i++) {
            sum += i;        
        } 

        return sum * sum;
    }

    get difference() {
        return this.squareOfSum - this.sumOfSquares;
    }
}
