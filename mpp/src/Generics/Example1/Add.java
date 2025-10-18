package Generics.Example1;

@FunctionalInterface
public interface Add<E> {
    E add(E a, E b);
}
