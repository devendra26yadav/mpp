package Generics.Example2;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static <T extends Comparable<? super T>> T max(T a, T b){
        return a.compareTo(b)>0?a:b;
    }
    public static <T> void print(Collection<? extends T> colls ){
        colls.forEach(e-> System.out.print(e+" " ));
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1,2,4,8,9,0);
        print(nums);
        List<Box<String>> boxes = List.of(new Box<String>("A"),new Box<>("B"));
        print(boxes);
    }
}
