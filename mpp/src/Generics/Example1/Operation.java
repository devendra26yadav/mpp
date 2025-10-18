package Generics.Example1;

public interface Operation <T>{
    T add(T a, T b);
    T sub(T a, T b);
    T multiply(T a, T b);
    T divide(T a, T b);
}
