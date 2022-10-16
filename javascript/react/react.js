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
    this.computeCells = [];

    this.inputCells.forEach(cell => cell.registerComputeCell(this));


    this.value = this.callback(this.inputCells); 
  }

  addCallback(cb) {
    // TODO
  }

  removeCallback(cb) {
    // TODO
  }

  update() {
    this.value = this.callback(this.inputCells); 
    this.computeCells.forEach(cell => cell.update());
  }

  registerComputeCell(computeCell) {
    this.computeCells.push(computeCell);
  }
}

export class CallbackCell {
  constructor(fn) {
    throw new Error('Remove this statement and implement this function');
  }
}
