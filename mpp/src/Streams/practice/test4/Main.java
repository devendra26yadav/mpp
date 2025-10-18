package Streams.practice.test4;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Address add1 = new Address("New York");
        Address add2 = new Address("Chicago");

        Section cs401 = new Section("CS401");
        Section cs545 = new Section("CS545");
        Section cs221 = new Section("CS221");

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(111, "Yasmeen", List.of(3.9, 4.0, 3.7), add1, List.of(cs545, cs401)),
                new Student(112, "Mira", List.of(4.0, 4.0, 3.9), add1, List.of(cs545, cs401, cs221)),
                new Student(113, "Zaina", List.of(3.6, 3.3, 3.7), add1, List.of(cs221)),
                new Student(114, "Khaled", List.of(3.0, 2.8, 3.1), add2, null)
        ));

        // 👉 Call the method (you will implement it)
        Student mostCoursesStudent = getStudentWithMostCourses(students);

        if (mostCoursesStudent != null) {
            System.out.println("Student enrolled in most courses: " + mostCoursesStudent.getName());
        } else {
            System.out.println("No student has enrolled in any course.");
        }
        // Counting students -> course count
        System.out.println("Name - Number of courses");
        var entrySets = getStudentCourseCounts(students).entrySet();
        for(var set:entrySets){
            System.out.println(set.getKey()+" "+set.getValue());
        }

        //Group students by the number of courses they are enrolled in.
        System.out.println("Group students by the number of courses they are enrolled in");
        var entrySets2 = groupStudentsByCourseCount(students).entrySet();
        for(var set:entrySets2){
            System.out.println(set.getKey()+" "+set.getValue());
        }

    }

    // 🧠 IMPLEMENT THIS METHOD
    public static Student getStudentWithMostCourses(List<Student> students) {
        // TODO: Implement this method using Optional.ofNullable and Stream
        return students.stream()
                .filter(student-> Optional.ofNullable(student.getSections())
                        .map(sec->!sec.isEmpty())
                        .orElse(false))
                 .max(Comparator.comparingInt(s->Optional.ofNullable(s.getSections())
                         .orElse(Collections.emptyList())
                         .size()))
                 .orElse(null);

    }
    public static Map<String, Integer> getStudentCourseCounts(List<Student> students)
    {
        return students.stream()
                .collect(Collectors.toMap(
                   Student::getName,
                   student -> Optional.ofNullable(student.getSections())
                           .orElse(Collections.emptyList())
                           .size()
                ));
    }
    public static Map<Integer, List<String>> groupStudentsByCourseCount(List<Student> students)
    {
        return students.stream()
                .collect(Collectors.groupingBy(
                        student-> Optional.ofNullable(student.getSections())
                                .orElse(Collections.emptyList())
                                .size(),
                        Collectors.mapping(Student::getName,Collectors.toList())

                ));
    }

}