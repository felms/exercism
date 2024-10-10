export class Series {

    #digits;

    constructor(series) {
        if (!series) {
            throw new Error('series cannot be empty')
        }

        this.#digits = [...series].map(Number);
    }

    slices(sliceLength) {
        if (sliceLength > this.#digits.length) {
            throw new Error('slice length cannot be greater than series length');
        }

        if (sliceLength == 0) {
            throw new Error('slice length cannot be zero');
        }

        if (sliceLength < 0) {
            throw new Error('slice length cannot be negative');
        }

        return [...Array(this.#digits.length - sliceLength + 1).keys()]
                .map(i => this.#digits.slice(i, i + sliceLength))
    }
}
