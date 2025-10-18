package Labs_solutions.lab13.prob2;

import java.util.*;

public class Group<T> {
    private T specialElement;
    private List<T> elements = new ArrayList<>();

    public Group(T special, List<T> elements) {
        this.specialElement = special;
        this.elements = elements;
    }

    public T getSpecialElement() {
        return specialElement;
    }

    public List<T> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return "Group{specialElement=" + specialElement + ", elements=" + elements + "}";
    }

    public static Group<?> copy(Group<?> group) {
        return copyHelper(group);
    }

    private static <T> Group<T> copyHelper(Group<T> group) {
        T special = group.getSpecialElement();
        List<T> elements = group.getElements();
        return new Group<>(special, elements);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        Group<Integer> intGroup = new Group<>(0, nums);

        System.out.println("Original: " + intGroup);

        Group<?> copiedGroup = Group.copy(intGroup);
        System.out.println("Copy: " + copiedGroup);

        List<String> strings = Arrays.asList("a", "b", "c");
        Group<String> stringGroup = new Group<>("special", strings);

        System.out.println("Original: " + stringGroup);

        Group<?> copiedStringGroup = Group.copy(stringGroup);
        System.out.println("Copy: " + copiedStringGroup);
    }
}
