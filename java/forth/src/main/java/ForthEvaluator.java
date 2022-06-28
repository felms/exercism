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
                    } else if (item.matches("[-+*/]")) {
                        processOperation(item);
                    }
            });
    }

    private void processOperation(String operation) {

        if (this.stack.size() < 2) {
            String operationName = "";

            switch(operation) {
                case "+":
                    operationName = "Addition";
                    break;
                case "-":
                    operationName = "Subtraction";
                    break;
                case "*":
                    operationName = "Multiplication";
                    break;
                case "/":
                    operationName = "Division";
                    break;

            };

            String message = String.format("%s requires that the stack contain at least 2 values"
                    , operationName);
            throw new IllegalArgumentException(message);
        }

        int a = this.stack.remove(this.stack.size() - 1);
        int b = this.stack.remove(this.stack.size() - 1);
        switch(operation) {
            case "+":
                this.stack.add(b + a);
                break;
            case "-":
                this.stack.add(b - a);
                break;
            case "*":
                this.stack.add(b * a);
                break;
            case "/":
                if (a == 0) {
                    throw new IllegalArgumentException("Division by 0 is not allowed");
                }
                this.stack.add(b / a);
                break;

        };

    }

}
