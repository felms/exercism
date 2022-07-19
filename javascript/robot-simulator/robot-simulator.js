export class InvalidInputError extends Error {
    constructor(message) {
        super();
        this.message = message || 'Invalid Input';
    }
}

export class Robot {

    constructor() {
        this.state = {direction: 'north', x: 0, y: 0};
    }

    get bearing() {
        return this.state.direction;
    }

    get coordinates() {
        return [this.state.x, this.state.y];
    }

    place({ x, y, direction }) {

        if (!(direction === 'north' || direction === 'south'
            || direction === 'east' || direction === 'west')){
            throw new InvalidInputError();
        }

        this.state.direction = direction;
        this.state.x = x;
        this.state.y = y;
    }

    evaluate(instructions) {

        switch (instructions) {
            case 'R':
                this.turnRight();
                break;
            case 'L':
                this.turnLeft();
                break;
            case 'A':
                this.advance();
                break;

        };
    }

    turnRight() {

        if (this.state.direction === 'north') {
            this.state.direction = 'east';
        } else if (this.state.direction === 'east') {
            this.state.direction = 'south';
        } else if (this.state.direction === 'south') {
            this.state.direction = 'west';
        } else if (this.state.direction === 'west') {
            this.state.direction = 'north';
        }

    }

    turnLeft() {

        if (this.state.direction === 'north') {
            this.state.direction = 'west';
        } else if (this.state.direction === 'west') {
            this.state.direction = 'south';
        } else if (this.state.direction === 'south') {
            this.state.direction = 'east';
        } else if (this.state.direction === 'east') {
            this.state.direction = 'north';
        }

    }

    advance() {

        if (this.state.direction === 'north') {
            this.state.y++;
        } else if (this.state.direction === 'west') {
            this.state.x--;
        } else if (this.state.direction === 'south') {
            this.state.y--;
        } else if (this.state.direction === 'east') {
            this.state.x++;
        }

    }
}

