package lesson09.lecture.new_java.interface_example.diamond.private_methods;

public class MyClass implements A{
	
	private void help() {
		System.out.println("Helping in MyClass");
	}
	
	public void show() {
		help();
	}
	
	public static void main(String[] args) {
		MyClass obj = new MyClass();
		obj.show();
	}
}
