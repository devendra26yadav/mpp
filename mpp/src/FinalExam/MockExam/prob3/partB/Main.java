package FinalExam.MockExam.prob3.partB;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {15,45,25,50,20,35,60,10};
        System.out.println(sumTwoNumbers(numbers));
    }
    public static int sumTwoNumbers(int[] numbers){
        return Arrays.stream(numbers)
                .filter(n->n>=30)
                .limit(2)
                .sum();



    }
}
