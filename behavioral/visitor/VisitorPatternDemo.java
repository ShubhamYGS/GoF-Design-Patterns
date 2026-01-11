package visitor;

import visitor.impl.Circle;
import visitor.impl.Rectangle;
import visitor.implvisitor.AreaCalculatorVisitor;
import visitor.implvisitor.SvgExporterVisitor;
import visitor.intf.Shape;
import visitor.intfvisitor.ShapeVisitor;

import java.util.List;

/**
 * Client/demo for the Visitor pattern.
 * The same list of shapes can be processed by different visitors (area, SVG, etc.).
 */
public class VisitorPatternDemo {
    public static void main(String[] args) {
        List<Shape> shapes = List.of(
                new Circle(5),
                new Rectangle(10, 4),
                new Circle(2.5)
        );

        System.out.println("=== Calculating Areas ===");
        ShapeVisitor areaCalculator = new AreaCalculatorVisitor();
        for (Shape shape : shapes) {
            shape.accept(areaCalculator);
        }

        System.out.println("\n=== Exporting to SVG ===");
        // Swap the visitor to add a new operation without changing Shape classes.
        ShapeVisitor svgExporter = new SvgExporterVisitor();
        for (Shape shape : shapes) {
            shape.accept(svgExporter);
        }
    }
}