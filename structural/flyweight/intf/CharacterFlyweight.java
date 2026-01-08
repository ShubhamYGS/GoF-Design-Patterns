package flyweight.intf;

/**
 * Flyweight interface for drawing a character glyph.
 * The glyph stores shared (intrinsic) data like font/color, while position is provided at draw time.
 */
public interface CharacterFlyweight {
    // x and y are "extrinsic" state: they change per use and are NOT stored in the flyweight.
    void draw(int x, int y);
}