package Labs_solutions.lab5.prob2;

public class DecoyDuck extends Duck{
   public DecoyDuck(){
       super.fly= new CannotFly();
       super.quack= new MuteQuack();
   }

    @Override
    public void display() {
        System.out.println("  displaying");
    }
}
