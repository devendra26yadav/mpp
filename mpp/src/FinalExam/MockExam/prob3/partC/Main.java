package FinalExam.MockExam.prob3.partC;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(streamSumOfSquares(3));
    }
    public static int streamSumOfSquares(int n){
        var nums = Stream.iterate(1,x->x+1).limit(n);
        return nums.mapToInt(i->i*i)
                .sum();
    }
}
