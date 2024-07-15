export class BankAccount {

    #balance;
    #isOpen;
    constructor() {
        this.#balance = 0;
        this.#isOpen = false;
    }

    open() {
        if (this.#isOpen) {
            throw new ValueError();
        }

        this.#isOpen = true;
    }

    close() {
        if (!this.#isOpen) {
            throw new ValueError();
        }

        this.#isOpen = false;
        this.#balance = 0;
    }

    deposit(value) {
        if (!this.#isOpen || value < 0) {
            throw new ValueError();
        }

        this.#balance += value;
    }

    withdraw(value) {
        if (!this.#isOpen 
            || value > this.#balance || value < 0) {
            throw new ValueError();
        }

        this.#balance -= value;
    }

    get balance() {
        if (!this.#isOpen) {
            throw new ValueError();
        }

        return this.#balance;
    }
}

export class ValueError extends Error {
    constructor() {
        super('Bank account error');
    }
}
