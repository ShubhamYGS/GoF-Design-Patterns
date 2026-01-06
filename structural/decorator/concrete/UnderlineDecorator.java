package decorator.concrete;

import decorator.abstractclass.TextDecorator;
import decorator.intf.TextView;

// Decorator to add underline style to text
public class UnderlineDecorator extends TextDecorator {
    public UnderlineDecorator(TextView inner) {
        super(inner);
    }

    @Override
    public void render() {
        // Print underline tags before and after rendering inner text
        System.out.print("<u>");
        inner.render();
        System.out.print("</u>");
    }
}