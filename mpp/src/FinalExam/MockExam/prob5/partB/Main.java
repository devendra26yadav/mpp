package FinalExam.MockExam.prob5.partB;

import java.util.Collection;
import java.util.List;

public class Main {
    public static  <T> void print(Collection<? extends T> colls){
        if(colls==null || colls.isEmpty()) return;
        colls.forEach(e-> System.out.print(e+" "));
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(1,2,3,4,5,6);
        print(arr);
        List<String> arr2 = List.of("A","B","C");
        print(arr2);
    }
}
