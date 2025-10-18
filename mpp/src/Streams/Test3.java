package Streams;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        List<Double> values = List.of(2.5, 3.0, 4.5);

       double value = values.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println(value);

    }
}
