package decorator.impl;

import decorator.intf.TextView;

// Basic implementation of TextView that displays plain text
public class PlainTextView implements TextView {
    private final String text;

    // Constructor to set the text content
    public PlainTextView(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        // Print the plain text
        System.out.print(text);
    }
}