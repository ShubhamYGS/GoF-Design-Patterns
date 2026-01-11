package interpreter.impl;

import interpreter.Context;
import interpreter.intf.Expression;

/**
 * TerminalExpression: a variable name (like "a" or "b") whose value comes from the Context.
 */
public class VariableExpression implements Expression {
    private final String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Context context) {
        return context.getValue(name);
    }
}
