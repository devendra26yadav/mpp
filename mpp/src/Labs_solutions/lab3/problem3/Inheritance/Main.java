package Labs.lab3.problem3.Inheritance;

public class Main {
    public static void main(String[] args) {
        Cylinder cylinder = new Circle(5);
        System.out.printf("Cylinder Volume : %.2f",cylinder.computeVolume());
        System.out.printf("\nCircle Area : %.2f",new Circle(5).computeArea());
    }
}
