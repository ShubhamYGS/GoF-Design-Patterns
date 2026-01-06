package decorator.concrete;

import decorator.abstractclass.TextDecorator;
import decorator.intf.TextView;

// Decorator to add italic style to text
public class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(TextView inner) {
        super(inner);
    }

    @Override
    public void render() {
        // Print italic tags before and after rendering inner text
        System.out.print("<i>");
        inner.render();
        System.out.print("</i>");
    }
}