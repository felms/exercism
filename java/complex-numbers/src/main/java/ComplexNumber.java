class ComplexNumber {

    private double real;
    private double imaginary;

    ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    double getReal() {
        return this.real;
    }

    double getImaginary() {
        return this.imaginary;
    }

    double abs() {
        return Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
    }

    ComplexNumber add(ComplexNumber other) {
        double r = this.real + other.getReal();
        double i = this.imaginary + other.getImaginary();
        return new ComplexNumber(r, i);
    }

    ComplexNumber subtract(ComplexNumber other) {
        double r = this.real - other.getReal();
        double i = this.imaginary - other.getImaginary();
        return new ComplexNumber(r, i);
    }

    ComplexNumber multiply(ComplexNumber other) {
        double r = this.real * other.getReal() - this.imaginary * other.getImaginary();
        double i = this.imaginary * other.getReal() + this.real * other.getImaginary();
        return new ComplexNumber(r, i);
    }

    ComplexNumber multiply(double factor) {
        return this.multiply(new ComplexNumber(factor, 0));
    }

    ComplexNumber divide(ComplexNumber other) {
        double div = Math.pow(other.getReal(), 2) + Math.pow(other.getImaginary(), 2);
        double r = this.real * other.getReal() + this.imaginary * other.getImaginary();
        double i = this.imaginary * other.getReal() - this.real * other.getImaginary();
        return new ComplexNumber(r / div, i / div);
    }

    ComplexNumber divide(double divisor) {
        return this.divide(new ComplexNumber(divisor, 0));
    }

    ComplexNumber conjugate() {
        return new ComplexNumber(this.real, -this.imaginary);
    }

    ComplexNumber exponentialOf() {
        return new ComplexNumber(Math.cos(this.imaginary), Math.sin(this.imaginary))
                        .multiply(Math.pow(Math.E, this.real));
    }

}
