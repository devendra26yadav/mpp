package Labs_solutions.lab5.prob2;

public class RubberDuck extends Duck{
    public RubberDuck(){
        super.fly= new CannotFly();
        super.quack= new Squeak();
    }

    @Override
    public void display() {
        System.out.println("  displaying");
    }
}
