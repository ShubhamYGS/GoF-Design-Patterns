package bridge;

import bridge.abstarctclass.Shape;
import bridge.concrete.Circle;
import bridge.concrete.Rectangle;
import bridge.impl.RasterRenderer;
import bridge.impl.VectorRenderer;
import bridge.intf.Renderer;


// Small demo that shows the Bridge pattern in action:
// - Renderer: different rendering backends (Vector vs Raster)
// - Shape: abstraction hierarchy (Circle, Rectangle) that delegates
//   drawing to a Renderer so both hierarchies can vary independently.
public class BridgeDemo {
    public static void main(String[] args) {
        Renderer vector = new VectorRenderer();
        Renderer raster = new RasterRenderer();

        Shape circle1 = new Circle(vector, 5);
        Shape circle2 = new Circle(raster, 5);

        Shape rectangle1 = new Rectangle(vector, 10, 4);
        Shape rectangle2 = new Rectangle(raster, 10, 4);

        // Each shape delegates drawing to its renderer.
        circle1.draw();     // Vector
        circle2.draw();     // Raster
        rectangle1.draw();  // Vector
        rectangle2.draw();  // Raster
    }
}