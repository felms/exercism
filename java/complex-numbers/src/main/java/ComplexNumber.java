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
        double real = this.getReal();
        double img = this.getImag();
        double otherReal = other.getReal();
        double otherImg = other.getImag();

        double newReal = real * otherReal - img * otherImg;
        double newImg = img * otherReal + real * otherImg;

        return new ComplexNumber(newReal, newImg);
    }

    public ComplexNumber div(ComplexNumber other) {
        double real = this.getReal();
        double img = this.getImag();
        double otherReal = other.getReal();
        double otherImg = other.getImag();

        double newReal = (real * otherReal + img * otherImg) 
                            / (Math.pow(otherReal, 2) + Math.pow(otherImg, 2));
        double newImg = (img * otherReal - real * otherImg) 
                            / (Math.pow(otherReal, 2) + Math.pow(otherImg, 2));

        return new ComplexNumber(newReal, newImg);
    }

    public double abs() {
        double real = this.getReal();
        double img = this.getImag();
        return Math.sqrt(real * real + img * img);
    }

    public ComplexNumber conjugate() {
        double real = this.getReal();
        double img = this.getImag();
        return new ComplexNumber(real, -1 * img);
    }

    public ComplexNumber exponentialOf() {
        return null; //TODO
    }
}