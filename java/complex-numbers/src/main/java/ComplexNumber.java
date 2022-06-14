public class ComplexNumber {

    private final double real;
    private final double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return this.real;
    }

    public double getImag() {
        return this.imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        double real = this.getReal();
        double img = this.getImag();
        double otherReal = other.getReal();
        double otherImg = other.getImag();
        return new ComplexNumber(real + otherReal, img + otherImg);
    }

    public ComplexNumber minus(ComplexNumber other) {
        double real = this.getReal();
        double img = this.getImag();
        double otherReal = other.getReal();
        double otherImg = other.getImag();
        return new ComplexNumber(real - otherReal, img - otherImg);
    }

    public ComplexNumber times(ComplexNumber other) {
        return null; //TODO
    }

    public ComplexNumber div(ComplexNumber other) {
        return null; //TODO
    }

    public double abs() {
        return -1; //TODO
    }

    public ComplexNumber conjugate() {
        return null; //TODO
    }

    public ComplexNumber exponentialOf() {
        return null; //TODO
    }
}