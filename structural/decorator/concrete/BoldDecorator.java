package decorator.concrete;

import decorator.abstractclass.TextDecorator;
import decorator.intf.TextView;

// Decorator to add bold style to text
public class BoldDecorator extends TextDecorator {
    public BoldDecorator(TextView inner) {
        super(inner);
    }

    @Override
    public void render() {
        // Print bold tags before and after rendering inner text
        System.out.print("<b>");
        inner.render();
        System.out.print("</b>");
    }
}