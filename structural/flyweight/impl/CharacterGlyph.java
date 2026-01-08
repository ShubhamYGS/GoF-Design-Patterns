package flyweight.impl;

import flyweight.intf.CharacterFlyweight;

/**
 * Concrete Flyweight: a single character glyph with shared styling info.
 * Intrinsic state (shared): symbol, font, size, color.
 */
public class CharacterGlyph implements CharacterFlyweight {
    private final char symbol;
    private final String fontFamily;
    private final int fontSize;
    private final String color;

    public CharacterGlyph(char symbol, String fontFamily, int fontSize, String color) {
        this.symbol = symbol;
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.color = color;
    }

    @Override
    public void draw(int x, int y) {
        // x and y are extrinsic state: provided by the caller for each render operation.
        System.out.println("Drawing '" + symbol + "' [Font: " + fontFamily +
                ", Size: " + fontSize + ", Color: " + color + "] at (" + x + "," + y + ")");
    }
}