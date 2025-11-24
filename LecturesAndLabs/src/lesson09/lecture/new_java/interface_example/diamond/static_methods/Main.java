package lesson09.lecture.new_java.interface_example.diamond.static_methods;

interface A {
	static void print() {
		System.out.println("A");
	}
}

interface B {
	static void print() {
		System.out.println("B");
	}
}

public class Main {

	public static void main(String[] args) {
		A.print(); // Calls A's version
		B.print(); // Calls B's version
	}

}
