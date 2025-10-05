package Labs_solutions.lab5.prob3;

public class Circle implements Shape{
    private final double radius;
    public Circle(double radius){
        this.radius= radius;
    }
    public double computeArea() {
        return Math.PI * radius * radius;
    }
}
