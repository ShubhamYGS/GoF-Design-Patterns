package visitor.impl;

import visitor.intf.Shape;
import visitor.intfvisitor.ShapeVisitor;

/**
 * ConcreteElement (a specific Shape).
 * It knows how to "accept" a visitor, but it doesn't know what the visitor will do.
 */
public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        // Double-dispatch: choose the correct visit method based on the runtime type (Circle).
        visitor.visitCircle(this);
    }
}