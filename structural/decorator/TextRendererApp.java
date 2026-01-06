package decorator;

import decorator.concrete.BoldDecorator;
import decorator.concrete.ItalicDecorator;
import decorator.concrete.UnderlineDecorator;
import decorator.impl.PlainTextView;
import decorator.intf.TextView;

public class TextRendererApp {
    public static void main(String[] args) {
        // Create a plain text view
        TextView text = new PlainTextView("Simple Text");

        // Render plain text
        System.out.print("Plain: ");
        text.render();
        System.out.println();

        // Render text with bold style
        System.out.print("Bold: ");
        TextView boldText = new BoldDecorator(text);
        boldText.render();
        System.out.println();

        // Render text with italic and underline styles
        System.out.print("Italic + Underline: ");
        TextView italicUnderline = new UnderlineDecorator(new ItalicDecorator(text));
        italicUnderline.render();
        System.out.println();

        // Render text with bold, italic, and underline styles
        System.out.print("Bold + Italic + Underline: ");
        TextView allStyles = new UnderlineDecorator(new ItalicDecorator(new BoldDecorator(text)));
        allStyles.render();
        System.out.println();
    }
}