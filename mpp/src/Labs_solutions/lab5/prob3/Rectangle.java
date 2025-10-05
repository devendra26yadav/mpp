package Labs_solutions.lab5.prob3;

public class Rectangle implements Shape{
    private final double width;
    private final double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
   public  double computeArea(){
        return width * length;
    }
}
