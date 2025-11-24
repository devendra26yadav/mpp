package lesson09.lecture.new_java.interface_example.syntax;

//Interface definition
public interface Vehicle {
	// Constant (implicitly public static final)
	String TYPE = "Transport";

	// Abstract method (must be implemented by classes)
	public abstract void start();

	// Default method (Java 8+) with implementation
	public default void stop() {
		log("In Stop....");
		System.out.println("Vehicle stopped.");
	}

	// Static method (Java 8+)
	public static void honk() {
		System.out.println("Beep beep!");
	}

	// Private method (Java 9+) for internal use
	private void log(String message) {
		System.out.println("Log: " + message);
	}
	
	
}
