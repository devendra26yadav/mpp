package lesson09.lecture.new_java.interface_example.default_methods;

public class ConsoleLogger extends AbstractLogger implements Logger {
	
	public void log(String message) {
		System.out.println("Console: " + message);
	}
	
	@Override
	public void logWarning(String msg) {
		System.out.println("ConsoleLogger - Warning: "+ msg);
	}
	
	public static void main(String[] args) {
		Logger log = new ConsoleLogger();
		log.logWarning("Hi");
	}
}
