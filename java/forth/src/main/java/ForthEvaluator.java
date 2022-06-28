import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;
import java.util.List;

public class ForthEvaluator{

    private final List<Integer> stack;

    public ForthEvaluator() {

        this.stack = new ArrayList<>();
    }

    public List<Integer> evaluateProgram(List<String> inputStack) {

        inputStack.forEach(this::evaluateExpression);

        return this.stack;
    }

    private void evaluateExpression(String expression) {

        Arrays.stream(expression.split("\\s+"))
            .forEach(item -> {
                    if (item.matches("\\d+")) {
                        this.stack.add(Integer.parseInt(item));
                    }
            });
    }
}
