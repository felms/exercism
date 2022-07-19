export class BankAccount {
    constructor() {
        this._balance = 0;
        this.openedAccount = false;
    }

    open() {
        if (this.openedAccount) {
            throw new ValueError();
        }

        this.openedAccount = true;
    }

    close() {
        if (!this.openedAccount) {
            throw new ValueError();
        }

        this._balance = 0;
        this.openedAccount = false;
    }

    deposit(ammount) {
        if (!this.openedAccount) {
            throw new ValueError();
        }

        if (ammount < 0) {
            throw new ValueError();
        }

        this._balance += ammount;
    }

    withdraw(ammount) {
        if (!this.openedAccount) {
            throw new ValueError();
        }

        if (ammount > this._balance || ammount < 0) {
            throw new ValueError();
        }

        this._balance -= ammount;
    }

    get balance() {
        if (!this.openedAccount) {
            throw new ValueError();
        }
        return this._balance;
    }
}

export class ValueError extends Error {
    constructor() {
        super('Bank account error');
    }
}
