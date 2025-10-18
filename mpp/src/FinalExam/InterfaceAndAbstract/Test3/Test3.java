package FinalExam.InterfaceAndAbstract.Test3;

interface A { default void act() { System.out.println("A"); } }
interface B extends A { default void act() { System.out.println("B"); } }
abstract class C implements A { }
class D extends C implements B { }
class Test {
    public static void main(String[] args) {
        new D().act();
    }
}

