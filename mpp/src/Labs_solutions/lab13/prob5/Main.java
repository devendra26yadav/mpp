package Labs_solutions.lab13.prob5;

import java.util.*;

import java.util.*;

public class Main {

    public static <T extends Comparable<? super T>> T secondSmallest(List<T> list) {
        if (list == null || list.size() < 2) {
            throw new IllegalArgumentException("List must contain at least two elements.");
        }

        T smallest = null;
        T secondSmallest = null;

        for (T element : list) {
            if (smallest == null || element.compareTo(smallest) < 0) {
                secondSmallest = smallest;
                smallest = element;
            } else if ((secondSmallest == null || element.compareTo(secondSmallest) < 0) && !element.equals(smallest)) {
                secondSmallest = element;
            }
        }

        if (secondSmallest == null) {
            throw new NoSuchElementException("No second smallest element found (all elements may be equal).");
        }

        return secondSmallest;
    }

    // Example usage
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 1, 2, 1, 3);
        System.out.println("Second smallest: " + secondSmallest(numbers)); // Output: 2

        List<String> words = Arrays.asList("apple", "banana", "cherry", "banana");
        System.out.println("Second smallest: " + secondSmallest(words)); // Output: banana
    }
}

