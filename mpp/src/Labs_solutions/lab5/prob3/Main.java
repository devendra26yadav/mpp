package Labs_solutions.lab5.prob3;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(12.45),
                new Rectangle(4.5, 9.6),
                new Triangle(12.5, 6)
        };

        System.out.printf("Sum of areas : %.2f",sumAreas(shapes));
    }
    public static double sumAreas(Shape[] shapes){
        double sums=0;
        for(Shape shape: shapes){
            sums+=shape.computeArea();
        }
        return sums;
    }
}
