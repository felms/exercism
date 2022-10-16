export class InputCell {
  constructor(value) {
    this.value = value;
    this.computeCells = [];
  }

  setValue(value) {
    this.value = value;

    this.computeCells.forEach(cell => cell.update());
  }

  registerComputeCell(computeCell) {
    this.computeCells.push(computeCell);
  }
}

export class ComputeCell {
  constructor(inputCells, fn) {
    this.callback = fn;
    this.inputCells = inputCells;

    this.inputCells.forEach(cell => cell.registerComputeCell(this));


    this.value = fn(this.inputCells);
  }

  addCallback(cb) {
    this.callbacks.push(cb);
  }

  removeCallback(cb) {
    let index = this.callbacks.indexOf(cb);
    this.callbacks.splice(index, 1);
  }

  update() {
    this.value = this.callback(this.inputCells);
  }
}

export class CallbackCell {
  constructor(fn) {
    throw new Error('Remove this statement and implement this function');
  }
}
