package Labs.lab3.problem3.Composition;

public class Circle {
    private double radius;
    public Circle(double radius){
        this.radius=radius;
    }
    public double getRadius(){
        return radius;
    }
    public double computeArea(){
        return Math.PI * radius * radius;
    }
}
