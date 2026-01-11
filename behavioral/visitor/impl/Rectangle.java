package visitor.impl;

import visitor.intf.Shape;
import visitor.intfvisitor.ShapeVisitor;

/**
 * ConcreteElement (a specific Shape).
 * It forwards operations to visitors via accept(...).
 */
public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        // Double-dispatch for Rectangle.
        visitor.visitRectangle(this);
    }
}