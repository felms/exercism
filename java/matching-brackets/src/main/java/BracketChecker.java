import java.util.Deque;
import java.util.LinkedList;

public class BracketChecker {

    private final char[] brackets;

    public BracketChecker(String brackets) {
        this.brackets = brackets.toCharArray();
    }

    public boolean areBracketsMatchedAndNestedCorrectly() {

        Deque<Character> stack = new LinkedList<>();

        for (char c : this.brackets) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else if (c == ']' || c == '}' || c == ')') {

                if(stack.isEmpty()) {
                    return false;
                }

                char topOfStack = stack.pop();
                if ((c == ']' && topOfStack != '[')
                        || (c == '}' && topOfStack != '{')
                        || (c == ')' && topOfStack != '(')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}