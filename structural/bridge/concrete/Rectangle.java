package bridge.concrete;

import bridge.abstarctclass.Shape;
import bridge.intf.Renderer;

/**
 * A concrete Shape that delegates drawing a rectangle to the Renderer.
 */
public class Rectangle extends Shape {
    private final float width;
    private final float height;

    public Rectangle(Renderer renderer, float width, float height) {
        super(renderer);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        // Delegate actual rendering to the provided renderer implementation
        renderer.renderRectangle(width, height);
    }
}