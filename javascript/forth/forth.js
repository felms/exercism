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
        }
    }
}
