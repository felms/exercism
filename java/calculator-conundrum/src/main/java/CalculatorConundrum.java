class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {

        try {

            int res = switch (operation) {
                case "+" -> operand1 + operand2;
                case "*" -> operand1 * operand2;
                case "/" -> operand1 / operand2;
                case null -> throw new IllegalArgumentException("Operation cannot be null");
                case "" -> throw new IllegalArgumentException("Operation cannot be empty");
                default -> throw new IllegalOperationException("Operation '" + operation + "' does not exist");
            };

            return String.format("%d %s %d = %d", operand1, operation, operand2, res);

        } catch (ArithmeticException ae) {
            throw new IllegalOperationException("Division by zero is not allowed", ae);
        }

    }
}
