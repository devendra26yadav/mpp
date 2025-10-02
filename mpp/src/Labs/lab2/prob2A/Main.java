package Labs.lab2.prob2A;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Devendra");
        student.getGradeReport().setGrade("A+");
        System.out.println(student);
        System.out.println(student.getGradeReport());

    }
}
