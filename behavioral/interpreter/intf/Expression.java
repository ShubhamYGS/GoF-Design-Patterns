package interpreter.intf;

import interpreter.Context;

/**
 * Expression role in the Interpreter pattern.
 * Every node in the expression tree can be evaluated using a Context.
 */
public interface Expression {
    int interpret(Context context);
}
