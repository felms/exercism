export class Crypto {

    #text;

    constructor(inputText) {
        this.#text = inputText.toLowerCase().replaceAll(/\W/g, '');
    }

    get ciphertext() {

        if (!this.#text) {
            return '';
        }

        // finds the size of each word
        let sqrt = Math.sqrt(this.#text.length);
        let cols = Math.ceil(sqrt);

        // splits the text into 'cols-sized' chunks
        let regex = new RegExp(`.{1,${cols}}`, 'g');
        let arr = this.#text.match(regex).map(w => w.padEnd(cols, ' '));

        // maps the current text to the 'encrypted' one
        return [...Array(cols).keys()]
            .map(col => arr.map(word => word.charAt(col)).join('')).join(' ');
    }

}
