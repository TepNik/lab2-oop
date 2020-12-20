
import java.util.Comparator;
import java.util.List;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Square;
import shapes.Triangle;


public class Main {
    public static void main(String[] args) {
        int max = 10;
        List<Shape> shapes = List.of(
                new Triangle(6.0, 7.0, 4.0),
                new Circle(Math.random() * max),
                new Rectangle(Math.random() * max, Math.random() * max),
                new Square(Math.random() * max)
        );
        double sumArea = 0;
        double sumPerimeter = 0;

        System.out.println("Shapes:");
        for (Shape shape : shapes) {
            System.out.println(shape);
            sumArea += shape.getArea();
            sumPerimeter += shape.getPerimeter();
        }

        System.out.println("Sum area: " + sumArea);
        System.out.println("Sum perimeter: " + sumPerimeter);

        Shape minByPerimeterShape = shapes.stream().min(Comparator.comparing(Shape::getPerimeter)).get();
        Shape maxByPerimeterShape = shapes.stream().max(Comparator.comparing(Shape::getPerimeter)).get();
        Shape minByAreaShape = shapes.stream().min(Comparator.comparing(Shape::getArea)).get();
        Shape maxByAreaShape = shapes.stream().max(Comparator.comparing(Shape::getArea)).get();

        System.out.println("Minimal perimeter: " + minByPerimeterShape.getPerimeter() + ", shape: " + minByPerimeterShape);
        System.out.println("Maximal perimeter: " + maxByPerimeterShape.getPerimeter() + ", shape: " + maxByPerimeterShape);
        System.out.println("Minimal area: " + minByAreaShape.getArea() + ", shape: " + minByAreaShape);
        System.out.println("Maximal area: " + maxByAreaShape.getArea() + ", shape: " + maxByAreaShape);
    }
}