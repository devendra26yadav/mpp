package lesson09.lecture.new_java.interface_example.diamond.rule3;

public interface B {
    default void show() {
        System.out.println("B");
    }
}
