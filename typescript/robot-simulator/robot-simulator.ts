export class InvalidInputError extends Error {
    constructor(message: string) {
        super()
        this.message = message || 'Invalid Input'
    }
}

type Direction = 'north' | 'east' | 'south' | 'west'
type Coordinates = [number, number]

export class Robot {

    private static DIRECTIONS = ['north', 'east', 'south', 'west'];
    private static STEPS = [[0, 1], [1, 0], [0, -1], [-1, 0]];

    private direction: string;
    private coord: [number, number];

    constructor() {
        this.direction = 'north';
        this.coord = [0, 0];
    }

    get bearing(): Direction {
        return this.direction as Direction;
    }

    get coordinates(): Coordinates {
        return this.coord as Coordinates;
    }

    place(newPlace: { x: number; y: number; direction: string }) {
        Robot.validateDirection(newPlace.direction);
        this.direction = newPlace.direction;
        this.coord = [newPlace.x, newPlace.y];
    }

    evaluate(instructions: string) {
        [...instructions].forEach(instruction => {
            switch(instruction) {
                case 'R':
                    this.turnRight();
                    break;
                case 'L':
                    this.turnLeft();
                    break;
                case 'A':
                    this.advance();
                    break;
                default:
                    break;
            }
        });
    }

    private static validateDirection(direction: string): void {
        if (!Robot.DIRECTIONS.includes(direction)) {
            throw new InvalidInputError('Invalid Input');
        }
    }

    private turnRight(): void {
        let pos = (Robot.DIRECTIONS.indexOf(this.direction) + 1) % 4
        this.direction = Robot.DIRECTIONS[pos];
    }

    private turnLeft(): void {
        let pos = (Robot.DIRECTIONS.indexOf(this.direction) + 3) % 4
        this.direction = Robot.DIRECTIONS[pos];
    }

    private advance(): void {
        let pos = Robot.DIRECTIONS.indexOf(this.direction);
        let [dX, dY] = Robot.STEPS[pos];
        this.coord[0] += dX;
        this.coord[1] += dY;
    }

}
