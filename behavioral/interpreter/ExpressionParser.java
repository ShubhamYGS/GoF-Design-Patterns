package interpreter;

import interpreter.impl.*;
import interpreter.intf.Expression;

import java.util.Stack;

/**
 * Simple parser for arithmetic expressions like: "a + b * 3".
 * Converts a string into an Expression tree (using operator precedence).
 */
public class ExpressionParser {

    public static Expression parse(String expression) {
        // values holds partial Expression trees (numbers, variables, and combined expressions)
        Stack<Expression> values = new Stack<>();
        // operators holds pending operators like + - *
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == ' ') continue;

            if (Character.isDigit(ch)) {
                // Read a full multi-digit number (e.g., 123)
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                i--; // step back because the for-loop will i++
                values.push(new NumberExpression(num));
            } else if (Character.isLetter(ch)) {
                // Variables are treated as single-letter names in this demo.
                values.push(new VariableExpression(String.valueOf(ch)));
            } else if (ch == '+' || ch == '-' || ch == '*') {
                // Apply any previous operators that have higher/equal precedence.
                while (!operators.isEmpty() &&
                        precedence(operators.peek()) >= precedence(ch)) {
                    values.push(applyOperator(
                            operators.pop(),
                            values.pop(),
                            values.pop()
                    ));
                }
                operators.push(ch);
            }
        }

        // Apply remaining operators to build the final expression tree.
        while (!operators.isEmpty()) {
            values.push(applyOperator(
                    operators.pop(),
                    values.pop(),
                    values.pop()
            ));
        }

        return values.pop();
    }

    private static int precedence(char op) {
        if (op == '*') return 2;
        if (op == '+' || op == '-') return 1;
        return 0;
    }

    private static Expression applyOperator(char op, Expression right, Expression left) {
        return switch (op) {
            case '+' -> new AddExpression(left, right);
            case '-' -> new SubtractExpression(left, right);
            case '*' -> new MultiplyExpression(left, right);
            default -> throw new IllegalArgumentException("Unknown operator: " + op);
        };
    }
}
