package lesson09.lecture.new_java.interface_example.default_methods;

public class AbstractLogger implements Logger{

	@Override
	public void log(String message) {
		System.out.println("AbstractLogger: " + message);
		
	}

	@Override
	public void logError(String message) {
		// TODO Auto-generated method stub
		
	}

	

}
