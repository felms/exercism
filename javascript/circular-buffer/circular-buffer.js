class CircularBuffer {

  #capacity;
  #usedSlots;
  #buffer;
  #currentPos;
  #insertPos;


  constructor(capacity) {
    this.#capacity = capacity;
    this.#usedSlots = 0;
    this.#buffer = [];
    this.#currentPos = 0;
    this.#insertPos = 0;

    for (let i = 0; i < capacity; i++) {
      this.#buffer.push('');
    }
  }

  write(item) {

    if (this.#usedSlots === this.#capacity) {
      throw new BufferFullError();
    }

    this.#buffer[this.#insertPos] = item;

    this.#insertPos++;
    this.#insertPos %= this.#capacity;

    this.#usedSlots++;

  }

  read() {
    if (this.#usedSlots === 0) {
      throw new BufferEmptyError();
    }

    let r = this.#buffer[this.#currentPos];

    this.#currentPos++;
    this.#currentPos %= this.#capacity;

    this.#usedSlots--;

    return r;

  }

  forceWrite(item) {

    if (this.#usedSlots === this.#capacity) {

      this.#buffer[this.#currentPos] = item;
      this.#currentPos++;
      this.#currentPos %= this.#capacity;

    } else {

      this.#buffer[this.#insertPos] = item;

      this.#insertPos++;
      this.#insertPos %= this.#capacity;

      this.#usedSlots++;

    }
  }

  clear() {
    this.#usedSlots = 0;
    this.#buffer = [];
    this.#currentPos = 0;
    this.#insertPos = 0;

    for (let i = 0; i < this.#capacity; i++) {
      this.#buffer.push('');
    }

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
