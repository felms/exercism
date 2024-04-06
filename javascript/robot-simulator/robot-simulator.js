export class InvalidInputError extends Error {
    constructor(message) {
        super();
        this.message = message || 'Invalid Input';
    }
}

const DIRECTIONS = ['north', 'east', 'south', 'west'];

export class Robot {

    constructor(direction = 'north') {
        this.#validateDirection(direction);
        this.direction = direction;
        this.coord = [0, 0];
    }

    get bearing() {
        return this.direction;
    }

    get coordinates() {
        return this.coord;
    }

    place({ x, y, direction }) {
        this.#validateDirection(direction);
        this.direction = direction;
        this.coord = [x, y];
    }

    evaluate(instructions) {
        for (let instruction of instructions) {
            if (['R', 'L'].includes(instruction)) {
                this.#turn(instruction);
            } else if (instruction === 'A') {
                this.#advance();
            }
        }
    }

    #validateDirection(direction) {
        if (!DIRECTIONS.includes(direction)) {
            throw new InvalidInputError();
        }
    }

    #turn(direction) {
        if (direction === 'R') {
            this.direction = DIRECTIONS[(DIRECTIONS.indexOf(this.direction) + 1) % 4];
        }

        if (direction === 'L') {
            this.direction = DIRECTIONS[(DIRECTIONS.indexOf(this.direction) + 3) % 4];
        }
    }

    #advance() {
        let [x, y] = this.coord;
        switch(this.direction) {
            case 'north':
                this.coord = [x, y + 1];
                break;
            case 'south':
                this.coord = [x, y - 1];
                break;
            case 'east':
                this.coord = [x + 1, y];
                break;
            case 'west':
                this.coord = [x - 1, y];
                break;
        }
    }
}
