package interpreter.impl;

import interpreter.Context;
import interpreter.intf.Expression;

/**
 * NonTerminalExpression: multiplies the result of two sub-expressions.
 */
public class MultiplyExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public MultiplyExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) * right.interpret(context);
    }
}
