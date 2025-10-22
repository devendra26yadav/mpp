package Generics.Example2.max;

public class Main {
    public static <T extends Comparable<T>> T max(T a, T b){
        return a.compareTo(b)>0?a:b;
    }

    public static void main(String[] args) {
        System.out.println(max(4,9));
        System.out.println(max(9.0,8.9));
        System.out.println(max("ABC","ABc"));
    }
}
