package FinalExam.MockExam.prob5.partA;

import java.util.Arrays;

public class Main {
    public static <T> void mySwap(T[] arr, int i, int j) {
        if (arr == null || arr.length == 0 || i < 0 || j < 0 || i >= arr.length || j >= arr.length || i == j) {
            throw new RuntimeException("Operation invalid");
        }
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(nums));
        mySwap(nums, 0, 2);
        System.out.println(Arrays.toString(nums));

    }
}
