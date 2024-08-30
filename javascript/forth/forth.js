export class Forth {

    #stack;
    #userDefinedInstructions;

    constructor() {
        this.#stack = [];
        this.#userDefinedInstructions = {};
    }

    evaluate(input) {
        let instructions = input.toLowerCase();

        if (/:.+;/.test(instructions)) {
            this.#addDefinition(instructions);
            return;
        }

        instructions.split(/\s+/g)
            .forEach((instruction) => this.#evaluateInstruction(instruction));
    }

    get stack() {
        return this.#stack;
    }

    #evaluateInstruction(instruction) {
        if (instruction in this.#userDefinedInstructions) {
            this.evaluate(this.#userDefinedInstructions[instruction]);
            return;
        }

        if (/-?\d+/.test(instruction)) {
            this.#stack.push(Number(instruction));
            return;
        }

        if (/(dup|drop|swap|over)/i.test(instruction)) {
            this.#stackManipulation(instruction);
            return;
        }

        if (/[-+*/]/.test(instruction)) {
            this.#arithmeticOperation(instruction);
            return;
        }

        throw new Error("Unknown command");
    }

    #arithmeticOperation(operation) {
        if (this.#stack.length < 2) {
            throw new Error("Stack empty");
        }

        let value1 = this.#stack.pop();
        let value0 = this.#stack.pop();

        switch (operation) {
            case "+":
                this.#stack.push(value0 + value1);
                break;
            case "-":
                this.#stack.push(value0 - value1);
                break;
            case "*":
                this.#stack.push(value0 * value1);
                break;
            case "/":
                if (value1 === 0) {
                    throw new Error("Division by zero");
                }
                this.#stack.push(Math.trunc(value0 / value1));
                break;
        }
    }

    #stackManipulation(operation) {
        switch (operation) {
            case "dup":
                if (this.#stack.length < 1) {
                    throw new Error("Stack empty");
                }
                let value = this.#stack[this.#stack.length - 1];
                this.#stack.push(value);
                break;
            case "drop":
                if (this.#stack.length < 1) {
                    throw new Error("Stack empty");
                }
                this.#stack.pop();
                break;
            case "swap":
                if (this.#stack.length < 2) {
                    throw new Error("Stack empty");
                }
                let value0 = this.#stack.pop();
                let value1 = this.#stack.pop();
                this.#stack.push(value0);
                this.#stack.push(value1);
                break;
            case "over":
                if (this.#stack.length < 2) {
                    throw new Error("Stack empty");
                }
                let item = this.#stack[this.#stack.length - 2];
                this.#stack.push(item);
                break;
        }
    }

    #addDefinition(newDefinition) {
        if (/:\s-?\d.*;/.test(newDefinition)) {
            throw new Error("Invalid definition");
        }

        let def = newDefinition.replaceAll(/[:;]/g, "").trim();
        let [_, definition, operation, ...rem] = /(\S+)\s(.*)/.exec(def);

        // In case we are a defined operation to define another operation.
        let op = operation.split(/\s/)[0] 
        if (op in this.#userDefinedInstructions) {
            let o = operation.replaceAll(op, this.#userDefinedInstructions[op]);
            this.#userDefinedInstructions[definition] = o;
            return;
        }

        this.#userDefinedInstructions[definition] = operation;
    }
}
