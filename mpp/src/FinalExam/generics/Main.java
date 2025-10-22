package FinalExam.generics;

import java.util.List;

public class Main {
    public static  <T extends Comparable<? super T>> T getMax(List<T> list){
        if(list==null || list.isEmpty())return null;
        T flag=list.getFirst();
        for(T e :list){
            if(e.compareTo(flag)>0){
                flag=e;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        List<Integer> nums =List.of(1,9,12,90,23,67,2,34);
        System.out.println(getMax(nums));
    }
}
