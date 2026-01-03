package bridge.abstarctclass;

import bridge.intf.Renderer;

/**
 * Abstraction in the Bridge pattern. Shapes delegate actual drawing
 * to a Renderer (implementor) so both hierarchies can vary independently.
 */
public abstract class Shape {
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
}