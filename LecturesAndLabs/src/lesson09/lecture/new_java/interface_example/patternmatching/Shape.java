package lesson09.lecture.new_java.interface_example.patternmatching;

public sealed interface Shape permits Circle, Rectangle, Square {
    double area();
}
