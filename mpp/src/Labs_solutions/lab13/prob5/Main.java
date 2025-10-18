package Labs_solutions.lab13.prob5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1,2,5,7,9);
        System.out.println(secondLargest(ints,Comparator.naturalOrder()));

    }
    public static <T> T secondLargest(List<T> nums,Comparator<? super T> comparator){
        if( nums==null||nums.isEmpty())return null;

        PriorityQueue<T> pq = new PriorityQueue<>(comparator.reversed());
         pq.addAll(nums);
         pq.poll();
         return pq.poll();
    }
}
