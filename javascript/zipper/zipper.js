export class Zipper {

  #tree;
  #root;
  #parent;

  constructor(tree, root, parent) {
    this.#tree = tree;
    this.#root = root || tree;
    this.#parent = parent || null;
  }

  static fromTree(tree) {
    return new Zipper(tree);
  }

  toTree() {
    return this.#root;
  }

  value() {
    return this.#tree.value;
  }

  left() {
    return this.#tree.left 
      ? new Zipper(this.#tree.left, this.#root, this.#tree)
      : null;
  }

  right() {
    return this.#tree.right
      ? new Zipper(this.#tree.right, this.#root, this.#tree)
      : null;
  }

  up() {
    return this.#parent
      ? new Zipper(this.#parent, this.#root)
      : null;
  }

  setValue(newValue) {
    this.#tree.value = newValue;
    return new Zipper(this.#tree, this.#root, this.#parent);
  }

  setLeft(left) {
    this.#tree.left = left;
    return new Zipper(this.#tree, this.#root, this.#parent);
  }

  setRight() {
    throw new Error('Remove this statement and implement this function');
  }
}
