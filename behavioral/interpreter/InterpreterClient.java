package interpreter;

import interpreter.intf.Expression;

import java.util.HashMap;
import java.util.Map;

/**
 * Client/demo for the Interpreter pattern.
 * Builds a Context (variable values), parses a string into an Expression tree, then interprets it.
 */
public class InterpreterClient {
    public static void main(String[] args) {

        // Context data: variable name -> value
        Map<String, Integer> vars = new HashMap<>();
        vars.put("a", 10);
        vars.put("b", 5);
        vars.put("c", 2);

        Context context = new Context(vars);

        // parse(...) builds an expression tree (AST) from the input string.
        Expression exp1 = ExpressionParser.parse("a + b * c");
        Expression exp2 = ExpressionParser.parse("a - b + c");

        // interpret(...) evaluates the expression using values from the context.
        System.out.println("a + b * c = " + exp1.interpret(context)); // 20
        System.out.println("a - b + c = " + exp2.interpret(context)); // 7
    }
}
