package lesson09.lecture.new_java.interface_example.diamond.rule3;

public class MyClass implements A, B {
    public void show() {
        // Must resolve the conflict explicitly
    	// Explicitly call A’s default method
    	A.super.show(); //B.super.show();
    }
}
