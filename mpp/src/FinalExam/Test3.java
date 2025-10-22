package FinalExam;

import java.util.Comparator;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(getMax(List.of(1,8,9,23,-1)));

    }
    public static <T extends Comparable<? super T>> T getMax(List<T> list){
        if(list==null||list.isEmpty()) return null;
        return list.stream()
                .max(Comparator.naturalOrder())
                .orElse(null);
    }
}
