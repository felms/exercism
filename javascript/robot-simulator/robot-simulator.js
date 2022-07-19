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
        throw new Error('Remove this statement and implement this function');
    }
}
