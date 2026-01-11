package visitor.intf;

import visitor.intfvisitor.ShapeVisitor;

/**
 * Element role in the Visitor pattern.
 * accept(...) lets a visitor perform an operation on this shape (double-dispatch).
 */
public interface Shape {
    void accept(ShapeVisitor visitor);
}