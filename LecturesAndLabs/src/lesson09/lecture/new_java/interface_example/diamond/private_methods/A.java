package lesson09.lecture.new_java.interface_example.diamond.private_methods;

public interface A {
	private void help() {
		System.out.println("Helping in A");
	}

	default void doSomething() {
		help(); // Valid — used inside the interface
	}
}
