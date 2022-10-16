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
    this.callbacks = [];

    this.inputCells.forEach(cell => cell.registerComputeCell(this));
    this.value = this.callback(this.inputCells); 
  }

  addCallback(cb) {
    this.callbacks.push(cb);
  }

  removeCallback(cb) {
    let index = this.callbacks.indexOf(cb);
    if (index >= 0) {
      this.callbacks.splice(index, 1);
    }
  }

  update() {
    let newValue = this.callback(this.inputCells); 

    if (newValue !== this.value) {
      this.value = newValue;
      this.computeCells.forEach(cell => cell.update());
      this.callbacks.forEach(callbackFn => callbackFn.execute(this));
    }
  }

  registerComputeCell(computeCell) {
    this.computeCells.push(computeCell);
  }
}

export class CallbackCell {
  constructor(fn) {
    this.cbFunction = fn;
    this.values = [];
  }

  execute(args) {
    this.values.push(this.cbFunction(args));
  }
}
