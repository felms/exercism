pub fn brackets_are_balanced(string: &str) -> bool {
    let mut stack = Vec::new();

    for c in string.chars() {
        if c == '(' || c == '[' || c == '{' {
            stack.push(c);
        } else if c == ')' || c == ']' || c == '}' {
            if stack.is_empty() {
                return false;
            }

            let &top = stack.last().unwrap();

            if c == ')' && top == '(' || c == ']' && top == '[' || c == '}' && top == '{' {
                stack.pop();
            } else {
                return false;
            }
        }
    }

    stack.is_empty()
}
