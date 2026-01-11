package interpreter;

import java.util.Map;

/**
 * Context in the Interpreter pattern.
 * Stores external information needed during evaluation (here: variable values).
 */
public class Context {
    private final Map<String, Integer> variables;

    public Context(Map<String, Integer> variables) {
        this.variables = variables;
    }

    public int getValue(String variable) {
        // If a variable isn't defined, we fail fast so the bug is obvious.
        if (!variables.containsKey(variable)) {
            throw new RuntimeException("Undefined variable: " + variable);
        }
        return variables.get(variable);
    }
}
