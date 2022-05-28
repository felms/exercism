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
    }

    public void simulate(String string) {
    }
    
}