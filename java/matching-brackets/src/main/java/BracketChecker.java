import java.util.Deque;
import java.util.LinkedList;

class BracketChecker {

    private String expression;

    BracketChecker(String expression) {
        this.expression = expression;
    }

    boolean areBracketsMatchedAndNestedCorrectly() {

        Deque<Character> stack = new LinkedList<>();

        for(char currentChar : this.expression.toCharArray()) {

            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                stack.push(currentChar);
            } else if (currentChar == ')' || currentChar == ']' || currentChar == '}') {

                if (stack.isEmpty()) {
                    return false;
                }

                char topOfStack = stack.pop();
                if ((currentChar == ')' && topOfStack != '(') || 
                        (currentChar == ']' && topOfStack != '[') || 
                        (currentChar == '}' && topOfStack != '{')) {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }
}
