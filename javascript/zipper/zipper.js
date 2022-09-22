export class Zipper {

  #value;
  #left;
  #right;
  #parent;

  constructor(value, parent = null) {
    this.#value = value;
    this.#parent = parent;
    this.#left = null;
    this.#right = null;
  }

  static fromTree(tree, parent = null) {
    let {value, left, right} = tree;
    let zipper = new Zipper(value, parent);


    if (left) {
      zipper.setLeft(Zipper.fromTree(left, zipper));
    }

    if (right) {
      zipper.setRight(Zipper.fromTree(right, zipper));
    }

    return zipper;

  }

  toTree() {

    let rootNode = this.clone();

    if (rootNode.up() !== null) {
      while (rootNode.up() !== null) {
        rootNode = rootNode.up();
      }
    }

    return Zipper.bt(rootNode);

  }

  value() {
    return this.#value;
  }

  left() {

    if (this.#left !== null) {
      return this.#left.clone();
    }

    return null;
  }

  right() {

    if (this.#right !== null) {
      return this.#right.clone();
    }

    return null;
  }

  up() {

    let zipper = null;

    if (this.#parent !== null) {
      zipper = this.#parent.clone();
    }

    return zipper;
  }

  setValue(value) {

    if (this.#parent === null) {
      this.#value = value;
      return this.clone();
    }

    let focusNode = this.#parent;
    let thisNode = this.clone();

    if (thisNode.equals(focusNode.left())) {
      thisNode.#value = value;
      focusNode.setLeft(thisNode);
      return focusNode.left();
    }

    if (thisNode.equals(focusNode.right())) {
      thisNode.#value = value;
      focusNode.setRight(thisNode);
      return focusNode.right();
    }

  }

  setLeft(left) {


    this.#left = left;

    if (this.#left !== null) {
      this.#left.setParent(this);
    }
  }

  setRight(right) {

    this.#right = right;

    if (this.#right !== null) {
      this.#right.setParent(this);
    }

  }

  setParent(parent) {
    this.#parent = parent;
  }

  static bt(zipper) {
    let value = zipper.value();
    let left = zipper.left() === null ? null : Zipper.bt(zipper.left());
    let right = zipper.right() === null ? null : Zipper.bt(zipper.right());

    return  {value, left, right};
  }

  clone() {
    let zipper = new Zipper(this.#value, this.#parent);
    let left = this.#left === null ? null : this.#left.clone();
    let right = this.#right === null ? null : this.#right.clone();
    zipper.setLeft(left);
    zipper.setRight(right);

    return zipper;
  }

  equals(otherZipper) {

    return JSON.stringify(Zipper.bt(this)) === JSON.stringify(Zipper.bt(otherZipper));

  }

  toString() {
    return "value: " + this.#value + ", " +
      "parent: " + (this.#parent == null ? "null" : "{ " + this.#parent.value() + " }") + ", " +
      "left: " + (this.#left == null ? "null" : "{ " + this.#left + " }") + ", " +
      "right: " + (this.#right == null ? "null" : "{ " + this.#right + " }");
  }
}
