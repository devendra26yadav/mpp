package lesson09.lecture.new_java.interface_example.diamond.rule1;

public interface A {
    default void show() {
        System.out.println("A");
    }
}
