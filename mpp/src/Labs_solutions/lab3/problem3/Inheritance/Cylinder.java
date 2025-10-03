package Labs.lab3.problem3.Inheritance;

public class Cylinder {
    private double height;
    private double radius;

    public Cylinder(double radius,double height){
        this.radius=radius;
        this.height=height;
    }
    public double getHeight(){
        return height;
    }
    public double computeVolume(){
        return Math.PI * radius * radius * height;
    }
}
