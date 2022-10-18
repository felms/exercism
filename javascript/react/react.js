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
    this._callback = fn;
    this._inputCells = inputCells;
    this._computeCells = [];
    this._callbacks = [];

    this._inputCells.forEach(cell => cell.registerComputeCell(this));
    this._value = this.value;
  }

  get value() {
    this._value = this._callback(this._inputCells); 
    return this._value;
  }

  addCallback(cb) {
    this._callbacks.push(cb);
  }

  removeCallback(cb) {
    let index = this._callbacks.indexOf(cb);
    if (index >= 0) {
      this._callbacks.splice(index, 1);
    }
  }

  update() {
    let newValue = this._callback(this._inputCells); 

    if (newValue !== this._value) {
      this._value = newValue;
      this._computeCells.forEach(cell => cell.update());
      this._callbacks.forEach(callbackFn => callbackFn.execute(this));
    }
  }

  registerComputeCell(computeCell) {
    this._computeCells.push(computeCell);
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
