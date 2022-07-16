export class Forth {
    constructor() {
        this._stack = [];
        this.userDefinedCommands = new Map();
    }

    evaluate(input) {
        this.evaluateExpression(input);
    }

    get stack() {
        return this._stack;
    }

    evaluateExpression(expression) {
        
        expression = (expression + '').toLowerCase();

        if (/:.+;/.test(expression)) {

            let s = expression.replaceAll(/[:;]/g, '').trim().split(/\s+/);
            let newCommand = s[0];

            if (/\d+/.test(newCommand)) {
                throw new Error('Invalid definition');
            }

            let cmdList = [];

            for (let i = 1; i < s.length; i++) {
                let str = s[i];
                if (this.userDefinedCommands.has(str)) {
                    cmdList.push(this.userDefinedCommands.get(str));
                } else {
                    cmdList.push(str);
                }

            }

            this.userDefinedCommands.set(newCommand, cmdList);

        } else {

            expression.split(/\s+/).forEach(item => {

                if (this.userDefinedCommands.has(item)) {
                    let command = this.userDefinedCommands.get(item); 
                    command.forEach(cmmd => this.evaluateExpression(cmmd));
                } else if (/\d+/.test(item)) {
                    this._stack.push(parseInt(item));
                } else if (/[-+*/]/.test(item)) {
                    this.arithmeticOperation(item);
                } else if (/(dup|drop|swap|over)/.test(item)) {
                    this.stackManipulation(item);
                }else {
                    throw new Error('Unknown command');
                }
            });
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
