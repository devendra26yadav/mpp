package lesson09.lecture.new_java.interface_example.sealed_demo;

public sealed interface Shape permits Circle, Rectangle, Square {
    double area();
}
