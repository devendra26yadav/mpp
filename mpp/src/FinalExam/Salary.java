package FinalExam;

@FunctionalInterface
public interface Salary<T > {
    void print(T t);
    String toString();
    default void m2(){
        System.out.println("Default m2()");
    }
    boolean equals(Object o);
}
