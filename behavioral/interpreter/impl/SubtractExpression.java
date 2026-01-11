package interpreter.impl;

import interpreter.Context;
import interpreter.intf.Expression;

/**
 * NonTerminalExpression: subtracts the right sub-expression from the left.
 */
public class SubtractExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }
}
