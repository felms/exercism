import java.util.Arrays;
import java.util.List;

public class Robot {

    private GridPosition gridPosition;
    private Orientation orientation;
    private List<Orientation> cardinals;

    public Robot(GridPosition initialGridPosition, Orientation initialOrientation) {
        this.gridPosition = initialGridPosition;
        this.orientation = initialOrientation;
        this.cardinals = Arrays.asList(Orientation.values());
    }

    public Object getOrientation() {
        return this.orientation;
    }

    public Object getGridPosition() {
        return this.gridPosition;
    }

    public void turnRight() {
        int pos = this.cardinals.indexOf(this.orientation);
        pos = (pos + 1) % 4;
        this.orientation = this.cardinals.get(pos);
    }

    public void turnLeft() {
        int pos = this.cardinals.indexOf(this.orientation);
        pos = (pos - 1) >= 0 ? pos - 1 : pos - 1 + 4;
        this.orientation = this.cardinals.get(pos);
    }

    public void advance() {
        int x = this.gridPosition.x;
        int y = this.gridPosition.y;

        switch(this.orientation) {
            case NORTH:
                y++;
                break;
            case EAST:
                x++;
                break;
            case SOUTH:
                y--;
                break;
            case WEST:
                x--;
                break;
        }

        this.gridPosition = new GridPosition(x, y);
    }

    public void simulate(String string) {

        Arrays.asList(string.split("")).forEach(action -> {
            switch(action) {
                case "R":
                    this.turnRight();
                    break;
                case "L":
                    this.turnLeft();
                    break;
                case "A":
                    this.advance();
                    break;
            }
        });
    }
    
}