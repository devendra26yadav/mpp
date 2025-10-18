package FinalExam.InterfaceAndAbstract.Test1;

interface A {
    void m1();
    void m2();
}

interface B extends A {
    default void m1() {
        System.out.println("B FROM m1");
    }
}

interface C extends A {
    default void m1() {
        System.out.println("C FROM m1");
    }
}

interface D extends B, C {
    @Override
    default void m1(){
        System.out.println("FROM D");
    }
}

abstract class E implements B, C {

public void m1(){
//    B.super.m1();
    System.out.println("E FROM Abstract class");
}

}
class F extends E{

   // @Override
    public void m2() {
        System.out.println("FROM F");
    }
}

public class Test1 {
    public static void main(String[] args) {
        E e = new F();
        e.m1();
        e.m2();
    }
}
