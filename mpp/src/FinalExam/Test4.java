package FinalExam;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        Optional<String> opt = Optional.ofNullable("Java");
        System.out.println(opt.orElse(getName()));
        System.out.println();
        System.out.println(opt.orElse("Default"));
        List<String> str = List.of("A","B","V");
        printList(str);
        //printList(opt);
        List<? extends Number> numbers = new ArrayList<Integer>();
       // numbers.add(10); // Compilation error?
        numbers.add(null);
        List<? super Integer> list = new ArrayList<Number>();
        list.add(10);
        Object obj = list.get(0);
        List<Integer> l2 = new ArrayList<>();
        test(l2);
        System.out.println(l2);

        List<?> l3 = new ArrayList<String>();
       // l3.add("Hello"); // Compilation error?
        Object o =l3.getFirst();


    }
    public static <T> void test(T t) {
        List<T> list = new ArrayList<>();
        list.add(t);
    }

    public static String getName(){
        System.out.println("Getting name");
        return "No name";
    }
    public static <T> void printList(Collection<? extends T> list) {
        for (T e : list) {
            System.out.println(e);
        }
    }
    public  static <T> void addToList(Collection<? super T> list, T t) {
        //list.add(42); // Valid
        T o =t;
        list.add(null);
        list.add(o);
        list.add(t);
    }


}
