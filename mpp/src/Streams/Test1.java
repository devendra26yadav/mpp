package Streams;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Test1 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7,8,9,10};
        // finding sum using stream

        long sum = Arrays.stream(nums).sum();
        System.out.println(sum);
        OptionalDouble average = OptionalDouble.of(Arrays.stream(nums).filter(e->(e%2==0)).count());
        System.out.println(average.getAsDouble());
    }
}
