package lesson09.lecture.new_java.interface_example.patternmatching;

public class AreaCalculator {
	public static double computeArea(Shape shape) {
		return switch (shape) {
			case Circle c -> c.area();
			case Rectangle r -> r.area();
			case Square s -> s.area();	
		};
	}
}
