package Streams.intermediate;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 20, 10,76, 50, 20, 70, 90);
        System.out.println("Sorted Elements ");
        print(sortDescending(numbers));
        // Remove duplicates from a list of strings
        List<String> strings = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        System.out.println("Removing Duplicates ");
        print(removeDuplicate(strings));
        // Sort employee names alphabetically
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 70000),
                new Employee("Bob", "IT", 85000),
                new Employee("Charlie", "IT", 65000),
                new Employee("Diana", "Finance", 75000)
        );
        System.out.println("Sorting Employee By Name");
        print(sortEmployeeByName(employees));
        // Flatten a list of lists of integers
        List<List<Integer>> nestedInts = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
        print(getFlatList(nestedInts));
        // Extract words from a list of sentences
        List<String> sentences = Arrays.asList(
                "Java is powerful",
                "Streams are cool",
                "FlatMap is useful"
        );
        System.out.println("Flat Strings ");
        print(extractWords(sentences));
        // List all product names from customers
        List<Customer> customers = Arrays.asList(
                new Customer("Tom", Arrays.asList("Laptop", "Phone")),
                new Customer("Jerry", Arrays.asList("Tablet", "Phone", "Monitor"))
        );
        System.out.println("Products Name");
        print(listProductsNames(customers));
        System.out.println("Max : "+getMax(numbers));
        System.out.println("Min : "+getMin(numbers));

        //Computer average salary of employee
        System.out.println("Average Salary : "+getAverageSalary(employees));
        System.out.println("Sum of numbers > 50 : "+sumOfGreaterThan50(numbers));

        System.out.println("Second Highest Number : "+secondHighestNumber(numbers));
        System.out.println("Words By Length");
        for(var set:groupingWordsByLength(strings).entrySet()){
            System.out.println(set.getKey()+" "+set.getValue());
        }

        Map<String, Double> grouped =groupSalaryByDepartment(employees);
        System.out.println("Grouping Salary By Department");
        grouped.forEach((dept,emp)-> System.out.println(dept+" "+emp));
        System.out.println("Grouping By Department");
        groupByDepartment(employees).forEach(
                (dept,emp)->
                        System.out.println(dept + " "+emp)
                );
        var evenAndOds = partitionIntoEvenAndOdd(numbers);
        System.out.println("Even numbers : "+evenAndOds.get(true));
        System.out.println("Odd numbers : "+evenAndOds.get(false));
    }
    public static Map<Boolean,List<Integer>> partitionIntoEvenAndOdd(List<Integer> nums){
        return nums.stream()
                .collect(Collectors.partitioningBy(n->n%2==0));
    }
    public static Map<String,List<Employee>> groupByDepartment(List<Employee> employees){
        return employees.stream()
                .filter(e->Optional.ofNullable(e.getDepartment())
                        .map(s->!s.isEmpty())
                        .orElse(false))
                .collect(Collectors.groupingBy(
                        e->e.getDepartment()
                ));
    }

    public static Map<String,Double> groupSalaryByDepartment(List<Employee> employees){
        return employees.stream()
                .filter(e->Optional.ofNullable(e.getDepartment())
                        .map(dept->!dept.isEmpty())
                        .orElse(false)
                )
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)
                ));
    }

    public static Map<Integer, List<String>> groupingWordsByLength(List<String> input){
        return input.stream()
                .collect(Collectors.groupingBy(
                        String::length
                ));
    }
    public static int secondHighestNumber(List<Integer> nums){
        return nums.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(-1);
    }
    public static int sumOfGreaterThan50(List<Integer> nums){
        return nums.stream()
                .filter(n->n>50)
                .mapToInt(i-> i)
                .sum();
    }
    public static double getAverageSalary(List<Employee> employees){
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

    }
    public static int getMin(List<Integer> nums){
        return nums.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0);
    }
    public static int getMax(List<Integer> nums){
        return nums.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }
    public static List<String> listProductsNames(List<Customer> customers){
        return customers.stream()
                .flatMap(c->c.getOrders().stream())
                .distinct()
                .collect(Collectors.toList());
    }
    public static List<String> extractWords(List<String> sentences){
        return sentences.stream()
                .flatMap(s->Arrays.stream(s.split(" ")))
                .map(w->w)
                .toList();
    }
    public static List<Integer> getFlatList(List<List<Integer>> ints){
        return ints.stream()
                .flatMap(l->l.stream().map(i->i))
                .toList();
    }
    public static List<Employee> sortEmployeeByName(List<Employee> employees){
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .toList();
    }
    public static List<String> removeDuplicate(List<String> input){
        return input.stream()
                .distinct()
                .collect(Collectors.toList());
    }
    public static List<Integer> sortDescending(List<Integer> input){
        return input.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
    }
    public static <T> void print(List<T> input){
        for(T e:input){
            System.out.print(e+" ");
        }
        System.out.println();
    }
}
