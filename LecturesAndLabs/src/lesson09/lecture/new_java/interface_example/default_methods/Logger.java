package lesson09.lecture.new_java.interface_example.default_methods;

/**
 * Now you want to add a new method logError(String error) to all Logger
 * implementations — but without breaking existing classes.
 */
public interface Logger {
	void log(String message);

	void logError(String message);
	
	public default void logWarning(String message) {
		log(message);
		System.out.println("Warning: "+ message);
	}
	
}
