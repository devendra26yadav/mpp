package Streams;

import java.util.stream.Collector;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {
        Stream<Integer> nums = Stream.iterate(0,x->x+1).limit(50);
        System.out.println(nums);
       // nums.forEach(x-> System.out.println(x));
        System.out.println("Get even numbers :");
       Stream<Integer> evens=nums.filter(x->x%2==0);
       evens.forEach(System.out::println);
    }
}
