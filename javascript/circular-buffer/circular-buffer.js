class CircularBuffer {

    #capacity;
    #elements;

    constructor(size) {
        this.#capacity = size;
        this.#elements = [];
    }

    write(item) {
        if (this.#elements.length === this.#capacity) {
            throw new BufferFullError("Buffer is full.");
        }

        this.#elements.push(item);
    }

    read() {
        if (this.#elements.length === 0) {
            throw new BufferEmptyError("Can't read from empty buffer.");
        }

        return this.#elements.shift();
    }

    forceWrite(item) {
        if (this.#elements.length === this.#capacity) {
            this.#elements.shift();
        }
        this.#elements.push(item);
    }

    clear() {
        this.#elements = [];
    }
}

export default CircularBuffer;

export class BufferFullError extends Error {
    constructor(message) {
        super(message);
    }
}

export class BufferEmptyError extends Error {
    constructor(message) {
        super(message);
    }
}
