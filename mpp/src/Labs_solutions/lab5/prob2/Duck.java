package Labs_solutions.lab5.prob2;

public abstract class Duck {
    protected FlyBehavior fly;
    protected QuackBehavior quack;
    public void quack(){
        quack.quack();
    }
    public void swim(){
        System.out.println("  swimming");
    }
    public abstract void  display();
    public void fly(){
        fly.fly();
    }
}
