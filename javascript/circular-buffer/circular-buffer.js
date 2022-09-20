class CircularBuffer {

  #capacity;
  #buffer;

  constructor(capacity) {
    this.#capacity = capacity;
    this.#buffer = [];
  }

  write(item) {

    if (this.#buffer.length === this.#capacity) {
      throw new BufferFullError();
    }

    this.#buffer.push(item);

  }

  read() {
    if (this.#buffer.length === 0) {
      throw new BufferEmptyError();
    }

    return this.#buffer.shift();

  }

  forceWrite(item) {

    if (this.#buffer.length === this.#capacity) {
      this.#buffer.shift();
    } 

    this.#buffer.push(item);

  }

  clear() {
    this.#buffer = [];
  }
}

export default CircularBuffer;

export class BufferFullError extends Error {
  constructor() {
    super('Buffer Full');
  }
}

export class BufferEmptyError extends Error {
  constructor() {
    super('Buffer Empty');
  }
}
