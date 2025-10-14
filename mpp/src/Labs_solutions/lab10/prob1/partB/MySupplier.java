package Labs_solutions.lab10.prob1.partB;

import java.util.function.Supplier;

public class MySupplier implements Supplier<Double> {
    @Override
    public Double get(){
        return Math.random()*100;
    }
}
