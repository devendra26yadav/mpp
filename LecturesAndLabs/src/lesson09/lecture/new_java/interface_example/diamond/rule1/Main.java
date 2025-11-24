package lesson09.lecture.new_java.interface_example.diamond.rule1;

public class Main {

	public static void main(String[] args) {
		A obj1 = new MyClass();
		obj1.show();
		
		SuperClass obj2 = new MyClass();
		obj2.show();
		
		MyClass obj3 = new MyClass();
		obj3.show();
	}

}
