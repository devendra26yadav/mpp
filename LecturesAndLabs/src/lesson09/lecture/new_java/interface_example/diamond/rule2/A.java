package lesson09.lecture.new_java.interface_example.diamond.rule2;

public interface A {
    default void show() {
        System.out.println("A");
    }
    
}
