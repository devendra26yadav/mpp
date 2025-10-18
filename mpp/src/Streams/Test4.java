package Streams;

import java.util.stream.IntStream;

public class Test4 {
    public static void main(String[] args) {
        IntStream.range(1,10)
                .filter(x->x>7)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

    }
}
