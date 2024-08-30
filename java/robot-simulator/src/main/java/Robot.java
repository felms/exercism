import java.util.Map;

class Robot {

    private static Orientation[] orientations = Orientation.values();
    private static int[][] steps = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // Had to do this because exercism's online test runner doesn't allow 
    // me to modify the Orientation and GridPosition classes, what would allow 
    // a cleaner solution.
    private static Map<Orientation, Integer> orientationIndex = Map.of(
        Orientation.NORTH, 0,
        Orientation.EAST,  1,
        Orientation.SOUTH, 2,
        Orientation.WEST,  3
    );

    private GridPosition position;
    private Orientation orientation;

    Robot(GridPosition initialPosition, Orientation initialOrientation) {
        this.position = initialPosition;
        this.orientation = initialOrientation;
    }

    GridPosition getGridPosition() {
        return this.position;
    }

    Orientation getOrientation() {
        return this.orientation;
    }

    void advance() {
        int[] step = steps[orientationIndex.get(this.orientation)];
        this.position = new GridPosition(this.position.x + step[0], this.position.y + step[1]);
    }

    void turnLeft() {
        this.orientation = orientations[(orientationIndex.get(this.orientation) + 3) % 4];
    }

    void turnRight() {
        this.orientation = orientations[(orientationIndex.get(this.orientation) + 1) % 4];
    }

    void simulate(String instructions) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'A':
                    this.advance();
                    break;
                case 'R':
                    this.turnRight();
                    break;
                case 'L':
                    this.turnLeft();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

}
