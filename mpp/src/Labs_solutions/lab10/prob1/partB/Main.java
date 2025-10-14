package Labs_solutions.lab10.prob1.partB;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Supplier<Double> randomNumber = ()->Math.random()*100;
        System.out.println("Random Number : "+randomNumber.get());

        System.out.println("Using class MySupplier ");
        MySupplier randomNumber2 = new MySupplier();
        System.out.println("Random Number : "+randomNumber2.get());

        System.out.println("Using inner class RandomSupplier");
        System.out.println("Random Number : "+new RandomSupplier().get());
    }

    static class RandomSupplier implements Supplier<Double>{
        @Override
        public Double get(){
            return Math.random()*100;
        }
    }
}
