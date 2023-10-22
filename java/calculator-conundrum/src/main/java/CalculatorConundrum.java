class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {

        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }

        if (operation.isBlank()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }

        if ("/".equals(operation) && operand2 == 0) {
            throw new IllegalOperationException("Division by zero is not allowed", new ArithmeticException());
        }

        return switch (operation) {

            case "+" -> formatResult(operand1, operand2, operation, operand1 + operand2);
            case "-" -> formatResult(operand1, operand2, operation, operand1 - operand2);
            case "*" -> formatResult(operand1, operand2, operation, operand1 * operand2);
            case "/" -> formatResult(operand1, operand2, operation, operand1 / operand2);
            default -> throw new IllegalOperationException("Operation '" + operation + "' does not exist");

        };
    }

    private String formatResult(int operand1, int operand2, String operation, int result) {
        return String.format("%d %s %d = %d", operand1, operation, operand2, result);
    }
}
