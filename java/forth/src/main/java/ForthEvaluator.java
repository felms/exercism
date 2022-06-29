import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ForthEvaluator{

    private final List<Integer> stack;
    private final Map<String, List<String>> userDefinedCommands;

    public ForthEvaluator() {

        this.stack = new ArrayList<>();
        this.userDefinedCommands = new HashMap<>();
    }

    public List<Integer> evaluateProgram(List<String> input) {

        input.forEach(this::evaluateExpression);
        return this.stack;

    }

    private void evaluateExpression(String expression) {

        expression = expression.toLowerCase();
        
        if (expression.matches(":.+;")) { // Se for definição de novo comando

            String[] s = expression.replaceAll("[:;]", "").trim().split("\\s+");
            String newCommand = s[0];
            
            if (newCommand.matches("\\d+")) {
                throw new IllegalArgumentException("Cannot redefine numbers");
            }

            List<String> cmdList = new ArrayList<>();
            
            for (int i = 1; i < s.length; i++) {
                String str = s[i];
                if (userDefinedCommands.containsKey(str)) {
                    cmdList.addAll(userDefinedCommands.get(str));
                } else {
                    cmdList.add(str);
                }

            }

            userDefinedCommands.put(newCommand, cmdList);

        } else { // Se for execução de comando

            Arrays.stream(expression.split("\\s+"))
                .forEach(item -> {
                        if (userDefinedCommands.containsKey(item)) {
                            List<String> command = userDefinedCommands.get(item); 
                            command.forEach(this::evaluateExpression);
                        } else if (item.matches("\\d+")) {
                            this.stack.add(Integer.parseInt(item));
                        } else if (item.matches("[-+*/]")) {
                            arithmeticOperation(item);
                        } else if (item.matches("(dup|drop|swap|over)")) {
                            stackManipulation(item);
                        } else {
                            throw new IllegalArgumentException("No definition available for " 
                                                + "operator \"" + item + "\"");
                        }
            });
        }
    }

    private void arithmeticOperation(String operation) {

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

            }

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

        }

    }

    private void stackManipulation(String operation) {
        
        switch(operation) {
            case "dup":
                this.dup();
                break;
            case "drop":
                this.drop();
                break;
            case "swap":
                this.swap();
                break;
            case "over":
                this.over();
                break;

        }

    }
    
    private void dup() {
        
        if (this.stack.size() < 1) {
            throw new IllegalArgumentException("Duplicating requires that the stack"
                           + " contain at least 1 value");
        }
        
        int a = this.stack.get(this.stack.size() - 1);
        this.stack.add(a);
    }
    
    private void drop() {
        if (this.stack.size() < 1) {
            throw new IllegalArgumentException("Dropping requires that the stack"
                           + " contain at least 1 value");
        }
        
        this.stack.remove(this.stack.size() - 1);

    }

    private void swap() {
        
        if (this.stack.size() < 2) {
            throw new IllegalArgumentException("Swapping requires that the stack"
                           + " contain at least 2 values");
        }
        
        int a = this.stack.remove(this.stack.size() - 1);
        int b = this.stack.remove(this.stack.size() - 1);
        this.stack.add(a);
        this.stack.add(b);
    }
    
    private void over() {
        
        if (this.stack.size() < 2) {
            throw new IllegalArgumentException("Overing requires that the stack"
                           + " contain at least 2 values");
        }
        
        int a = this.stack.get(this.stack.size() - 2);
        this.stack.add(a);
    }

}
