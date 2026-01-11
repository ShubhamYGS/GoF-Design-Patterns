package interpreter.impl;

import interpreter.Context;
import interpreter.intf.Expression;

/**
 * TerminalExpression: a constant number in the expression tree.
 */
public class NumberExpression implements Expression {
    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Context context) {
        return number;
    }
}
