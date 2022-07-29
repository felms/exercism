export class Crypto {

    #normalizedInput;
    #columns;
    #rows;

    constructor(inputText) {
        this.#normalizedInput = inputText.toLowerCase().replaceAll(/\W/g, '');
        this.#columns = this.#numberOfColumns();
        this.#rows = this.#numberOfRows();
    }

    get ciphertext() {
        
        if (this.#normalizedInput.length === 0) {
            return '';
        }

        // Adding padding to the string
        let text = this.#normalizedInput;
        while (text.length < this.#rows * this.#columns) {
            text = text.concat(' ');
        }

        // Dividing the string in equal sized chunks
        let chunks = [];

        let begin = 0;
        let end = this.#columns;

        while (end <= text.length) {
            chunks.push(text.substring(begin, end));
            begin += this.#columns;
            end += this.#columns;
        }

        // Create the encoded string
        let esList = [];
        for (let j = 0; j < this.#columns; j++) {
            let cString = '';
            for (let i = 0; i < this.#rows; i++) {
                let c = chunks[i].charAt(j);
                cString = cString.concat(c);
            }
            esList.push(cString);
        }

        return esList.join(' ');
    }

    #numberOfColumns () {

        let stringSize = this.#normalizedInput.length;
        let i = 1;
        while (i * i < stringSize) {
            i++;
        }

        return i;
    }

    #numberOfRows() {

        let i = this.#columns - 1;
        let stringSize = this.#normalizedInput.length;
        return i * this.#columns >= stringSize ? i : this.#columns;
    }
}
