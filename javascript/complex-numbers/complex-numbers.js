export class ComplexNumber {

    #real;
    #imaginary;

    constructor(real, imaginary) {
        this.#real = real;
        this.#imaginary = imaginary;
    }

    get real() {
        return this.#real;
    }

    get imag() {
        return this.#imaginary;
    }

    add(otherNumber) {
        let r = this.#real + otherNumber.real;
        let i = this.#imaginary + otherNumber.imag;
        return new ComplexNumber(r, i);
    }

    sub(otherNumber) {
        let r = this.#real - otherNumber.real;
        let i = this.#imaginary - otherNumber.imag;
        return new ComplexNumber(r, i);
    }

    div(otherNumber) {
        let den = Math.pow(otherNumber.real, 2) + Math.pow(otherNumber.imag, 2);
        let r = (this.#real * otherNumber.real + this.imaginary * otherNumber.imag)
                    / den;
        let i = (this.#imaginary * otherNumber.real - this.#real * otherNumber.imag) 
                    / den;
        return new ComplexNumber(r, i);
    }

    mul(otherNumber) {
        let r = this.#real * otherNumber.real - this.#imaginary * otherNumber.imag;
        let i = this.#imaginary * otherNumber.real + this.#real * otherNumber.imag;
        return new ComplexNumber(r, i);
    }

    get abs() {
        return Math.sqrt(Math.pow(this.#real, 2) + Math.pow(this.#imaginary, 2));
    }

    get conj() {
        return new ComplexNumber(this.#real, (-this.#imaginary));
    }

    get exp() {
        let a = new ComplexNumber(Math.pow(Math.E, this.#real), 0);
        let b = new ComplexNumber(Math.cos(this.#imaginary), 
                                    Math.sin(this.#imaginary));
        return a.mul(b);
    }
}
