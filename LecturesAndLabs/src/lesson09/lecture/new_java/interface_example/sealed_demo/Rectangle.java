package lesson09.lecture.new_java.interface_example.sealed_demo;

public sealed class Rectangle implements Shape permits ColoredRectangle {
    public double area() { return 2 * 3; }
}
