package Labs.lab3.problem3.Composition;

public class Main {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(new Circle(12),20);
        System.out.printf("Volume : %.2f",cylinder.computeVolume());
    }
}
