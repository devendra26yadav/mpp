package Labs_solutions.lab13.prob2;

import java.util.Arrays;
import java.util.List;

public class GroupUtil {

    public static Group<?> copy(Group<?> group) {
        return copyHelper(group);
    }


    private static <T> Group<T> copyHelper(Group<T> group) {
        T special = group.getSpecialElement();
        List<T> elements = group.getElements();
        return new Group<>(special, elements);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4);
        Group<Integer> group = new Group<>(0, list);
        System.out.println("Original Group:");
        System.out.println(group);

        System.out.println("\nCopied Group:");
        System.out.println(GroupUtil.copy(group));
    }
}
