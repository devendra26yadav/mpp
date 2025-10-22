package FinalExam;

import java.util.*;

public class Main {
    public static <T extends Comparable<? super T>> T secondSmallest(List< T> list){
        Collections.sort(list);
        T smallest = list.getFirst();
        for(int i=1;i<list.size();i++){
            if(list.get(i).compareTo(smallest)>0){
                return list.get(i);
            }
        }
        return null;
    }
    public static <T extends Comparable<? super T>> T getNthSmallest(List<T> list,int position){
        if(position<0||position>=list.size()) return null;
        TreeSet<T> set = new TreeSet<>(list);

        if (position >= set.size()) return null;

        int index = 0;
        for (T item : set) {
            if (index == position) return item;
            index++;
        }
        return null; // Should not reach here
    }

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1,4,7,1,9);
        System.out.println( secondSmallest(ints));
        System.out.println(secondSmallest(Arrays.asList("A","B","C","D","E")));
        System.out.println(getNthSmallest(ints,2));
    }
}
