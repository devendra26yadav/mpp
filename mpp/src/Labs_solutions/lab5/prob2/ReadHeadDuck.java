package Labs_solutions.lab5.prob2;

public class ReadHeadDuck extends Duck{
    public ReadHeadDuck(){
        super.fly= new FlyWithWings();
        super.quack= new Quack();
    }

    @Override
    public void display() {
        System.out.println("  displaying");
    }
}
