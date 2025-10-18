package Labs_solutions.lab11part2;



import java.util.*;
import java.util.stream.Collectors;

public class Main {
    //1. Find all the students that are taking a given course
    public static void  m1(List<Student> students){
        students.stream()
                .filter(s-> Optional.ofNullable(s.sections)
                        .map(list->!list.isEmpty())
                        .orElse(false))

                .map(Student::getName)
                .toList().forEach(System.out::println);
    }
    //2. Get the address of any student that is taking a given course (e.g., "CS401")
    public static List<Address> getStudentByCourse(List<Student> students, String course){
        return students.stream()
                .filter(s->Optional.ofNullable(s.sections)
                        .map(sections->sections
                                .stream()
                                .anyMatch(section -> section.getCourseCode().equalsIgnoreCase(course)))
                        .orElse(false)
                ).map(Student::getAddress).distinct().toList();
    }
    //3. get GPA
    public static double getGPAOfStudent(Student student){

        return student.grades.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

    }
    // 4.Find the student with the highest GPA
    public static Student getStudentWithHighestGPA(List<Student> students){
        return  students.stream()
                 .filter(student->Optional.ofNullable(student.getGrades())
                         .map(grade->!grade.isEmpty())
                         .orElse(false))
                 .max(Comparator.comparingDouble(s->Optional.ofNullable(s.getGrades())
                         .orElse(Collections.emptyList())
                         .stream()
                         .mapToDouble(Double::doubleValue)
                         .average()
                         .orElse(0.0)
                 )).orElse(null);


    }
    //5. Get a list of all unique courses taken by students
    public static List<String> getUniqueCourse(List<Student> students){
        return students.stream()
                .flatMap(s->Optional.ofNullable(s.sections)
                        .orElse(Collections.emptyList())
                        .stream())
                .map(Section::getCourseCode)
                .distinct()
                .toList();
    }

    //6. Find all students who live in a given city (e.g., "Fairfield") sorted in alphabetical order
    public static List<Student> getStudentsByCity(List<Student> students, String city){
        return students.stream()
                .filter(s->s.getAddress().getCity().equalsIgnoreCase(city))
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }
    //7. Count the number of students enrolled in a specific course (e.g., "CS401")
    public static Long countStudentInACourse(List<Student> students,String course){
        return students.stream()
                .flatMap(student->Optional.ofNullable(student.sections).orElse(Collections.emptyList()).stream())
                .filter(code->code.getCourseCode().equalsIgnoreCase(course)).count();
    }
    //8. Get a list of students in a specific section
    public static List<Student> getStudentBySection(List<Student> students, Section section){
        return students.stream()
                .filter(student->Optional.ofNullable(student.sections)
                        .map(s->s.stream().anyMatch(sec-> sec.equals(section)))
                        .orElse(false))
                .collect(Collectors.toList());
    }
    // 9. Get the names of students who have enrolled in more than a given number of courses (e.g., more than 2 courses)
    public static List<String> getStudentsEnrolledInMoreCourse(List<Student> students){
        return students.stream()
                .filter(student -> Optional.ofNullable(student.sections)
                        .map(sections->sections.size()>2)
                        .orElse(false))
                .map(Student::getName)
                .toList();
    }
    //10. Get a list of unique course names taken by students who live in a given city (e.g., "Fairfield")
    public static List<String> getUniqueCourseByCity(List<Student> students,String city){
        return students.stream()
                .filter(student -> Optional.ofNullable(student.getAddress())
                        .map(addr->addr.city.equalsIgnoreCase(city))
                        .orElse(false))
                .flatMap(s->Optional.ofNullable(s.sections)
                        .orElse(Collections.emptyList())
                        .stream())
                .map(code->code.getCourseCode())
                .distinct()
                .toList();
    }
    //11. Get a list of distinct addresses of students who are taking a specific course (e.g., "CS401")
    public static List<Address> getUniqueAddressByCourse(List<Student> students, String course)
    {
        return students.stream()
                .filter(student->Optional.ofNullable(student.sections)
                        .map(sections -> sections.stream()
                                .anyMatch(sec->sec.getCourseCode().equalsIgnoreCase(course)))
                        .orElse(false))
                .map(Student::getAddress)
                .distinct()
                .toList();
    }
    //12. Get a mapping of students' names to the list of courses they are taking
    public static Map<String,List<String>> getMappingStudentNameWithCourses(List<Student> students){
        return students.stream()
                .collect(Collectors.toMap(
                        student -> student.getName(),
                        student -> Optional.ofNullable(student.sections).orElse(Collections.emptyList())
                                .stream().map(Section::getCourseCode).toList()
                ));
    }

    public static void main(String[] args) {
        Address add1 = new Address("500 E Broadway Ave", "Fairfield", "IA", 52556);
        Address add2 = new Address("103 W Adams Ave", "Fairfield", "IA", 52556);

        Section cs545_1 = new Section(900, "CS545");
        Section cs545_2 = new Section(901, "CS545");
        Section cs401 = new Section(902, "CS401");
        Section cs221 = new Section(903, "CS221");

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(111, "Yasmeen", new ArrayList<>(Arrays.asList(3.9, 4.0, 3.7)), add1,
                        new ArrayList<>(Arrays.asList(cs545_1, cs401))),
                new Student(112, "Mira", new ArrayList<>(Arrays.asList(4.0, 4.0, 3.9)), add1,
                        new ArrayList<>(Arrays.asList(cs545_2, cs401, cs221))),
                new Student(113, "Zaina", new ArrayList<>(Arrays.asList(3.6, 3.3, 3.7)), add1,
                        new ArrayList<>(Arrays.asList(cs221, cs401))),
                new Student(114, "Khaled", new ArrayList<>(Arrays.asList(3.0, 2.8, 3.1)), add2)
        ));

        //1. Find all the students that are taking a given course
       m1(students);

        //2. Get the address of any student that is taking a given course (e.g., "CS401")
        System.out.println(getStudentByCourse(students,"CS401"));

        //3. Calculate the GPA for a given student
        Student s2 = new Student(112, "Mira", new ArrayList<>(Arrays.asList(4.0, 4.0, 3.9)), add1,
                new ArrayList<>(Arrays.asList(cs545_2, cs401, cs221)));
        System.out.println(getGPAOfStudent(s2));

        // 4.Find the student with the highest GPA
        System.out.println("Student with highest GPA");
        System.out.println(getStudentWithHighestGPA(students));
        //5. Get a list of all unique courses taken by students
        System.out.println(getUniqueCourse(students));

        //6. Find all students who live in a given city (e.g., "Fairfield") sorted in alphabetical order
        System.out.println(getStudentsByCity(students,"Fairfield"));

        //7. Count the number of students enrolled in a specific course (e.g., "CS401")
        System.out.println(countStudentInACourse(students,"CS401"));

        //8. Get a list of students in a specific section
        System.out.println(getStudentBySection(students,cs221));
        // 9. Get the names of students who have enrolled in more than a given number of courses (e.g., more than 2 courses)
        System.out.println(getStudentsEnrolledInMoreCourse(students));

        //10. Get a list of unique course names taken by students who live in a given city (e.g., "Fairfield")
        System.out.println(getUniqueCourseByCity(students,"Fairfield"));
        //11. Get a list of distinct addresses of students who are taking a specific course (e.g., "CS401")
        System.out.println(getUniqueAddressByCourse(students,"CS401"));

        //12. Get a mapping of students' names to the list of courses they are taking
        System.out.println("Students name with course List");
        for(var set :getMappingStudentNameWithCourses(students).entrySet()){
            System.out.println(set.getKey() + " -> "+set.getValue());
        }
    }
}
