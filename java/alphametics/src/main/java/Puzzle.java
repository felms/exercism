import java.util.ArrayList;
import java.util.List;

public record Puzzle(List<String> operands, String result) {

    public Puzzle(List<String> operands, String result) {
        this.operands = new ArrayList<>(operands);
        this.result = result;
    }

}
