package Streams.practice.set1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*
        Q1.
Write a lambda expression that takes a List<Integer> and prints only the numbers greater than 10 using forEach.
Use no explicit loop.
         */
        List<Integer> list = List.of(5, 12, 9, 30, 2);
        list.stream().filter(n -> n > 10).forEach(System.out::println);

        /*
        Q2.

         */
        List<String> words = Arrays.asList("apple", "carrot", "cake", "cap", "dog", "candy");

        System.out.println(countWords(words, 'c', 'x', 3)); // Implement this method

        /*
        Q3.
Given:

List<String> names = Arrays.asList("alex", "bob", "charlie");


Write a single stream pipeline that:

Converts all to uppercase

Adds "#" in front

Collects into a List<String>

Expected Result: ["#ALEX", "#BOB", "#CHARLIE"]
         */
        List<String> names = Arrays.asList("alex", "bob", "charlie");
        mapAndTransform(names).forEach(System.out::println);

        /*
        Q4
         */
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 5000, 25),
                new Employee("Bob", 7000, 30),
                new Employee("Charlie", 5000, 35),
                new Employee("David", 4000, 28)
        );
        sortEmployee(employees).forEach(System.out::println);

        employees.sort((e1,e2)->{
            int cmp = Double.compare(e1.getSalary(), e2.getSalary());
            if(cmp!=0) return cmp;
            return Integer.compare(e2.getAge(),e1.getAge());
        });
        System.out.println();
        employees.forEach(System.out::println);

    }

    public static long countWords(List<String> words, char c, char d, int len) {
        return words.stream()
                .filter(w -> w.length() == len)
                .filter(w -> w.contains("" + c))
                .filter(w -> !w.contains("" + d))
                .count();
    }
    public static List<String> mapAndTransform(List<String> list){
        return list.stream()
                .map(String::toUpperCase)
                .map(w->"#"+w)
                .collect(Collectors.toList());
    }

    public  static List<Employee> sortEmployee(List<Employee> employeeList){
       return  employeeList
                .stream()
                .sorted(
                        Comparator.comparing(Employee::getSalary)
                                .thenComparing(Employee::getAge).reversed()).toList();
    }
}
