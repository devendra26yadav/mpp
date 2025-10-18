package FinalExam.InterfaceAndAbstract.Test2.Main1;

interface A{
    default void show(){
        System.out.println("A.show() concrete");
    }
}
interface B {
    void show();
}
abstract class C{
    public void show(){
        System.out.println("C.show() abstract class");
    }
    //public abstract void show2();
}
class D extends C implements A,B{

}



public class Main1 {
    public static void main(String[] args) {
        new D().show();
    }
}
