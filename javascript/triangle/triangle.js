export class Triangle {
  constructor(...sides) {

      this.side1 = sides[0];
      this.side2 = sides[1];
      this.side3 = sides[2];
      
      this.isValidTriangle = function() {
        if (this.side1 <= 0 || this.side2 <= 0 || this.side3 <= 0) {
          return false;
        }
    
        if (this.side1 + this.side2 < this.side3 
            || this.side1 + this.side3 < this.side2 
            || this.side2 + this.side3 < this.side1) {
            return false;
        }
    
        return true;
      }
      
  }  

  get isEquilateral() {
    return this.isValidTriangle() &&
          (this.side1 === this.side2 && this.side1 === this.side3);
  }

  get isIsosceles() {
    return this.isValidTriangle() &&
          (this.side1 === this.side2 || this.side1 === this.side3 || this.side2 === this.side3);
  }

  get isScalene() {
    return this.isValidTriangle() &&
          (this.side1 !== this.side2 && this.side1 !== this.ide3 && this.side2 !== this.side3);
  }

  
}
