package FinalExam.InterfaceAndAbstract.Test2.Main2;


interface A{
    default void show(){
        System.out.println("A.show() concrete");
    }
   
}
interface B {
    void show();
}
abstract class C{
    public abstract void show();
}
class D extends C implements A,B{

    @Override
    public void show() {
        A.super.show();
    }
}
public class Main2 {
    public static void main(String[] args) {
        new D().show();
    }
}
