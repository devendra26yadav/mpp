package Labs_solutions.lab10.prob5;

import java.time.LocalDate;
import java.util.Date;
import java.util.function.*;

public class Example {
    public void evaluator(){
        // using String method reference
        Function<String, String> toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.apply("sky diving"));
        BiFunction<Integer,Integer,Integer> func = (x,y)->x+y;
        System.out.println("Sum : "+func.apply(5,9));

        Supplier<LocalDate>  todayDate = ()->LocalDate.now();
        System.out.println("Date : "+todayDate.get());

        Consumer<String> greet = (name)-> System.out.println("Hello "+name);
        greet.accept("Mike");

        Predicate<Integer> isEven = (num)->{
            return num % 2 == 0;
        };
        System.out.println("Is 7 even : "+isEven.test(7));
        System.out.println("Is 8 even : "+isEven.test(8));

        BinaryOperator<Integer> multiply = (a,b)->a*b;
        System.out.println("Multiply(4,7) : "+multiply.apply(4,7));



    }
    public static void main(String[] args) {
        Example ex = new Example();
        ex.evaluator();
    }
}
