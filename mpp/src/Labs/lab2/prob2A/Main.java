package Labs.lab2.prob2A;

class Student {
    private String name;
    private GradeReport gradeReport;

    Student(String name) {
        this.name = name;
        gradeReport = new GradeReport(this);
    }

   public GradeReport getGradeReport(){
        return gradeReport;
   }
   public String getName(){
        return name;
   }
}

class GradeReport {
    private Student student;
    GradeReport(Student student) {
        this.student=student;
    }
    public Student getStudent(){
        return student;
    }
}


public class Main {
    public static void main(String[] args) {
        Student student = new Student("Bob");
        GradeReport gradeReport = new GradeReport(student);
        System.out.println("Grade Report of "+gradeReport.getStudent().getName());
        System.out.println(student.getGradeReport().getStudent().getName());

    }
}
