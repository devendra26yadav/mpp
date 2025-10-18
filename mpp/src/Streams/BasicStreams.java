package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class BasicStreams {
    public static void main(String[] args) {
        List<Integer> numsList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 120, -2, 340,4,7,8, 13, 14, 15);

        System.out.println("All even numbers");
        getEvenNumbers(numsList).forEach(x-> System.out.print(x+" "));
        List<String> testStrings = Arrays.asList("hello", "java", "code", "AI","JavaScripts","congrats", "GPT", "", "test", "chat", "openai", "odd", "even");
        char startsWithLetter = 'c';
        System.out.println("\nList of String starts with letter "+startsWithLetter);
        startsWith(testStrings,startsWithLetter).forEach(s-> System.out.print(s+ " "));
        System.out.println("Number greater 10 ");
        getNumGreaterThan10(numsList).forEach(n-> System.out.print(n+" "));
        System.out.println("\nString length greater than 5");
        getStringLengthGreaterThan5(testStrings).forEach(s->System.out.print(s+" "));

        System.out.println("\nStrings in Upper Case");
        getStringUpperCase(testStrings).forEach(s->System.out.print(s+" "));

        System.out.println("\nGet Squares of each numbers");
        getSquaresOfNumbers(numsList).forEach(n-> System.out.print(n+" "));

        System.out.println("\nEvery first Characters ");
        getFirstCharacterList(testStrings).forEach(c-> System.out.print(c+" "));

        System.out.println("\nNumber greater than 100 : "+countNumbersGreaterThan100(numsList));

        System.out.println("All Evens : "+isAllEvenNumbers(Arrays.asList(2,6,8,10)));

        System.out.println("\nAny String Contains : "+anyStringContains(testStrings,"java"));

        System.out.println("Set of integers : ");
        getSetOfIntegers(numsList).forEach(n-> System.out.print(n+" "));
        System.out.println("\n"+joinStringByComma(testStrings));
    }
    public static String joinStringByComma(List<String> input){
       // return String.join(", ", input);
        return input.stream()
                .collect(Collectors.joining(", "));
    }
    public static Set<Integer> getSetOfIntegers(List<Integer> nums){
        return nums.stream()
                .collect(Collectors.toSet());

    }
    public static boolean anyStringContains(List<String> input, String str){
        return input.stream()
                .anyMatch(s->s.toLowerCase().contains(str.toLowerCase()));
    }
    public static boolean isAllEvenNumbers(List<Integer> nums){
        return nums.stream()
                .allMatch(n->n%2==0);

    }
    public static Long countNumbersGreaterThan100(List<Integer> nums){
        return nums.stream()
                .filter(n->n>100)
                .count();
    }
    public static List<Character> getFirstCharacterList(List<String> input){
        return input.stream()
                .filter(s->!s.isEmpty())
                .map(s->s.charAt(0))
                .toList();
    }
    public static List<Integer> getSquaresOfNumbers(List<Integer> nums){
        return nums.stream()
                .map(e->e*e)
                .toList();
    }
    public static List<String> getStringUpperCase(List<String> strings){
        return strings.stream()
                .map(s->s.toUpperCase())
                .collect(Collectors.toList());
    }
    public static List<String> getStringLengthGreaterThan5(List<String> nums){
        return nums.stream()
                .filter(s->s.length()>5)
                .toList();
    }
    public static List<Integer> getNumGreaterThan10(List<Integer> nums){
        return nums.stream()
                .filter(n->n>10)
                .toList();
    }
    public static List<String> startsWith(List<String> input, char c){
        return input.stream()
                .filter(s->s.startsWith(""+c))
                .toList();
    }
    public static List<Integer>  getEvenNumbers(List<Integer> lists){
        return lists.stream()
                .filter(x->x%2==0)
                .collect(Collectors.toList());
    }
}
