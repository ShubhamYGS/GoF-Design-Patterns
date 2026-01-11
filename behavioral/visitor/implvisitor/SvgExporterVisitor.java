package visitor.implvisitor;

import visitor.impl.Circle;
import visitor.impl.Rectangle;
import visitor.intfvisitor.ShapeVisitor;

/**
 * ConcreteVisitor: exports each shape into a simple SVG-like string.
 */
public class SvgExporterVisitor implements ShapeVisitor {
    @Override
    public void visitCircle(Circle circle) {
        System.out.println("<circle r=\"" + circle.getRadius() + "\" />");
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        System.out.println("<rect width=\"" + rectangle.getWidth() +
                "\" height=\"" + rectangle.getHeight() + "\" />");
    }
}