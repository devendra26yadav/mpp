package Generics.Example1;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Calculator<Integer> cal = new Calculator<>();
        System.out.println(cal.add(4,6));
        System.out.println(cal.sub(5,7));
        System.out.println(cal.div(2,3));
        Calculator<Integer> intCalc = new Calculator<>();
        System.out.println("Add Integers: " + intCalc.add(5, 3));

        Calculator<BigDecimal> bigCalc = new Calculator<>();
        System.out.println("Add BigDecimals: " + bigCalc.add(new BigDecimal("1.5"), new BigDecimal("2.3")));

        Maths m = new Maths();
        System.out.println("Add : "+m.add(6,9));

        Add<Double> ad = Double::sum;
        System.out.println(ad.add(5.0,7.0));
    }
}
