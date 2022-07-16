export class Forth {
    constructor() {
        this._stack = [];
    }

    evaluate(input) {
        input.split(' ').forEach(expression => this.evaluateExpression(expression));
    }

    get stack() {
        return this._stack;
    }

    evaluateExpression(expression) {

        if (/\d+/.test(expression)) {
            this._stack.push(parseInt(expression));
        } else if (/[-+*/]/.test(expression)) {
            this.arithmeticOperation(expression);
        } else if (/(dup|drop|swap|over)/.test(expression)) {
            this.stackManipulation(expression);
        }
    }

    arithmeticOperation(operation) {

        if(this._stack.length < 2) {
            throw new Error('Stack empty');
        }

        let a = this._stack.pop();
        let b = this._stack.pop();
        switch(operation) {
            case '+':
                this._stack.push(b + a);
                break;
            case '-':
                this._stack.push(b - a);
                break;
            case '*':
                this._stack.push(b * a);
                break;
            case '/':
                if (a == 0) {
                    throw new Error('Division by zero');
                }
                this._stack.push(Math.trunc(b / a));
                break;
        }
    }

    stackManipulation(operation) {

        switch(operation) {
            case 'dup':
                this.dup();
                break;
            case 'drop':
                this.drop();
                break;
            case 'swap':
                this.swap();
                break;
            case 'over':
                this.over();
                break;

        }
    }

    dup() {
        let len = this._stack.length;
        if (len === 0) {
            throw new Error('Stack empty');
        }

        let a = this._stack[len - 1];
        this._stack.push(a);
    }

    drop() {
        if (this._stack.length === 0) {
            throw new Error('Stack empty');
        }

        this._stack.pop();    
    }

    swap() {
        if (this._stack.length < 2) {
            throw new Error('Stack empty');
        }

        let a = this._stack.pop();
        let b = this._stack.pop();

        this._stack.push(a);
        this._stack.push(b);
    }

    over() {
        let len = this._stack.length;
        if (len < 2) {
            throw new Error('Stack empty');
        }

        let a = this._stack[len - 2];
        this._stack.push(a);
    }
}
