package Labs_solutions.lab5.prob2;

public class MallardDuck extends Duck{
    public MallardDuck(){
        super.fly= new FlyWithWings();
        super.quack= new Quack();
    }
    @Override
    public void display(){
        System.out.println("  display");
    }
}
