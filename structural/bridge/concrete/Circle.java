package bridge.concrete;

import bridge.abstarctclass.Shape;
import bridge.intf.Renderer;

/**
 * A concrete Shape that delegates drawing a circle to the Renderer.
 */
public class Circle extends Shape {
    private final float radius;

    public Circle(Renderer renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        // Delegate the actual drawing to the rendering backend
        renderer.renderCircle(radius);
    }
}