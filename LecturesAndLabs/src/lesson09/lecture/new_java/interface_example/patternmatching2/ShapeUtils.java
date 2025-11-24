package lesson09.lecture.new_java.interface_example.patternmatching2;

//Define the sealed interface and its permitted subtypes
sealed interface Shape permits Circle, Rectangle, Square {}

record Circle(double radius) implements Shape {}
record Rectangle(double length, double width) implements Shape {}
record Square(double side) implements Shape {}


public class ShapeUtils {

	public static String describe(Shape shape) {
        return switch (shape) {
            case Circle c -> "Circle with radius: " + c.radius();
            case Rectangle r -> "Rectangle with area: " + (r.length() * r.width());
            case Square s -> "Square with area: " + (s.side() * s.side());
        };
    }

    public static void main(String[] args) {
        Shape s1 = new Circle(2.0);
        Shape s2 = new Rectangle(3, 4);
        Shape s3 = new Square(5);

        System.out.println(describe(s1)); // Circle with radius: 2.0
        System.out.println(describe(s2)); // Rectangle with area: 12.0
        System.out.println(describe(s3)); // Square with area: 25.0
    }
}
