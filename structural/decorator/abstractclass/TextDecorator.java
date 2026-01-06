package decorator.abstractclass;

import decorator.intf.TextView;

// Abstract decorator class for text views
public abstract class TextDecorator implements TextView {
    // Reference to the inner TextView being decorated
    protected final TextView inner;

    // Constructor to set the inner TextView
    public TextDecorator(TextView inner) {
        this.inner = inner;
    }
}