package lesson09.lecture.new_java.interface_example.default_methods;

public class FileLogger extends AbstractLogger {
	public void log(String message) {
		System.out.println("Writing to file: " + message);
	}
}
