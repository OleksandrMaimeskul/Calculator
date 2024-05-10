
package Service;

public class ExpressionEvaluator {
    public double evaluateExpression(String expression) {
        try {
            String[] parts = expression.split("[+\\-*/]");

            if (parts.length < 2) {
                throw new IllegalArgumentException("Incomplete expression");
            }

            double operand1 = Double.parseDouble(parts[0]);
            double operand2 = Double.parseDouble(parts[1]);

            char operator = expression.charAt(parts[0].length());

            switch (operator) {
                case '+':
                    return operand1 + operand2;
                case '-':
                    return operand1 - operand2;
                case '*':
                    return operand1 * operand2;
                case '/':
                    if (operand2 == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    return operand1 / operand2;
                default:
                    throw new IllegalArgumentException("Invalid operator");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numbers in expression");
        } catch (Exception e) {
            throw new IllegalArgumentException("Error evaluating expression");
        }
    }
}
