const ALPHABET_LENGTH = 26;
const FIRST_LETTER = 'a'.charCodeAt(0);

export class Cipher {

    #key;

    constructor(key) {
        this.#key = !key ? this.#generateKey() : key;
    }

    encode(plainText) {

        return [...plainText].map((letter, i) => {
            let shift = this.#key.charCodeAt(i % this.#key.length) - FIRST_LETTER;
            let plainTextPos = letter.charCodeAt(0) - FIRST_LETTER;
            let cipherPos = (shift + plainTextPos) % ALPHABET_LENGTH;
            return String.fromCharCode(cipherPos + FIRST_LETTER);
        }).join('');
    }

    decode(cipherText) {

        return [...cipherText].map((letter, i) => {
            let shift = this.#key.charCodeAt(i % this.#key.length) - FIRST_LETTER;
            let cipherTextPos = letter.charCodeAt(0) - FIRST_LETTER;
            let plainTextPos = cipherTextPos - shift;
            plainTextPos = plainTextPos < 0 ? plainTextPos + ALPHABET_LENGTH : plainTextPos;
            return String.fromCharCode(plainTextPos + FIRST_LETTER);
        }).join('');
    }

    get key() {
        return this.#key;
    }

    #generateKey() {
        return [...Array(100).keys()]
            .map(_ => String.fromCharCode(Math.floor(Math.random() * ALPHABET_LENGTH) + FIRST_LETTER))
            .join('');
    }
}
