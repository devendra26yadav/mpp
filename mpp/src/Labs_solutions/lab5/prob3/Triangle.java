package Labs_solutions.lab5.prob3;

public class Triangle implements Shape{
    private final double base;
    private final double height;
    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }
    @Override
    public double computeArea() {
        return (base*height)/2;
    }
}
