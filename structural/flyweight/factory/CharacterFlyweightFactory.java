package flyweight.factory;

import flyweight.impl.CharacterGlyph;
import flyweight.intf.CharacterFlyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight factory that creates and caches glyphs.
 * Same (symbol + style) => same shared flyweight instance.
 */
public class CharacterFlyweightFactory {
    // Cache of already-created flyweights keyed by intrinsic state (symbol + style).
    private final Map<String, CharacterFlyweight> flyweightMap = new HashMap<>();

    public CharacterFlyweight getFlyweight(char symbol, String fontFamily, int fontSize, String color) {
        // Key represents intrinsic state (what can be shared across many characters).
        String key = symbol + fontFamily + fontSize + color;

        // Create only if missing; otherwise reuse the existing object.
        flyweightMap.putIfAbsent(key, new CharacterGlyph(symbol, fontFamily, fontSize, color));
        return flyweightMap.get(key);
    }

    public int getFlyweightCount() {
        // How many unique glyph objects we ended up creating (lower is better sharing).
        return flyweightMap.size();
    }
}