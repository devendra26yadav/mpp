package Labs.lab3.problem3.Composition;

public class Cylinder {
    private double height;
    private Circle base;

    public Cylinder(Circle base,double height){
        if(base==null) throw new IllegalArgumentException("Circle cannot be null");
        this.base=base;
        this.height=height;
    }
    public double getHeight(){
        return height;
    }
    public double computeVolume(){
        return base.computeArea() * height;
    }
}
