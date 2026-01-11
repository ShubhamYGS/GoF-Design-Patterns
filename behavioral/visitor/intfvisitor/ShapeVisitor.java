package visitor.intfvisitor;

import visitor.impl.Circle;
import visitor.impl.Rectangle;

/**
 * Visitor role in the Visitor pattern.
 * Each visitX method contains the logic for a specific Shape type.
 */
public interface ShapeVisitor {
    void visitCircle(Circle circle);

    void visitRectangle(Rectangle rectangle);
}