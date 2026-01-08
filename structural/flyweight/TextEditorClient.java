package flyweight;

import flyweight.factory.CharacterFlyweightFactory;
import flyweight.intf.CharacterFlyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * Client-like class that builds a "document" made of characters.
 * It stores extrinsic state (x,y) per character, while sharing glyph objects via the factory.
 */
class TextEditorClient {
    private final CharacterFlyweightFactory factory = new CharacterFlyweightFactory();

    // Each entry is one character on the screen: (shared glyph) + (position).
    private final List<RenderedCharacter> document = new ArrayList<>();

    public void addCharacter(char c, int x, int y, String font, int size, String color) {
        // Get a shared flyweight based on intrinsic state (character + style).
        CharacterFlyweight glyph = factory.getFlyweight(c, font, size, color);

        // Store extrinsic state (position) separately so the flyweight stays shareable.
        document.add(new RenderedCharacter(glyph, x, y));
    }

    public void renderDocument() {
        for (RenderedCharacter rc : document) {
            rc.render();
        }
        System.out.println("Total flyweight objects used: " + factory.getFlyweightCount());
    }

    /**
     * Combines a shared glyph (intrinsic) with a specific position (extrinsic) for rendering.
     */
    private static class RenderedCharacter {
        private final CharacterFlyweight glyph; // shared object
        private final int x, y;                 // unique per character placement

        public RenderedCharacter(CharacterFlyweight glyph, int x, int y) {
            this.glyph = glyph;
            this.x = x;
            this.y = y;
        }

        public void render() {
            glyph.draw(x, y);
        }
    }
}