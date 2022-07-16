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

}
