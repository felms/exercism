export class ComplexNumber {
  
  constructor(realNumber, imaginary) {
    this.real = realNumber;
    this.imag = imaginary;
  }

  get real() {
    return this.realNumber;
  }

  get imag() {
    return this.imaginary;
  }

  set real(real) {
    this.realNumber = real;
  }

  set imag(imag) {
    this.imaginary = imag
  }

  add(other) {
    let real = this.real;
    let img = this.imag;
    let otherReal = other.real;
    let otherImg = other.imag;
    return new ComplexNumber(real + otherReal, img + otherImg);
  }

  sub(other) {
    let real = this.real;
    let img = this.imag;
    let otherReal = other.real;
    let otherImg = other.imag;
    return new ComplexNumber(real - otherReal, img - otherImg);
  }

  div(other) {
    let real = this.real;
    let img = this.imag;
    let otherReal = other.real;
    let otherImg = other.imag;

    let newReal = (real * otherReal + img * otherImg) 
                        / (Math.pow(otherReal, 2) + Math.pow(otherImg, 2));
    let newImg = (img * otherReal - real * otherImg) 
                        / (Math.pow(otherReal, 2) + Math.pow(otherImg, 2));

    return new ComplexNumber(newReal, newImg);
  }

  mul(other) {
    let real = this.real;
    let img = this.imag;
    let otherReal = other.real;
    let otherImg = other.imag;

    let newReal = real * otherReal - img * otherImg;
    let newImg = img * otherReal + real * otherImg;

    return new ComplexNumber(newReal, newImg);
  }

  get abs() {
    let real = this.real;
    let img = this.imag;
    return Math.sqrt(real * real + img * img);
  }

  get conj() {
    let real = this.real;
    let img = this.imag;
    return new ComplexNumber(real, (img === 0 ? 0 : (-1 * img)));
  }

  get exp() {
    let real = this.real;
    let img = this.imag;

    let a =  new ComplexNumber(Math.pow(Math.E, real), 0);
    let b  = new ComplexNumber(Math.cos(img), Math.sin(img));

    return a.mul(b);
  }
}
