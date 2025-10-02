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
   public void setName(String name){
        this.name=name;
   }
   @Override
    public String toString(){
        return name+" : "+gradeReport;
   }
}

class GradeReport {
    private Student student;
    private String grade;
    GradeReport(Student student) {
        this.student=student;
    }
    public Student getStudent(){
        return student;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    @Override
    public String toString(){
        return grade;
    }
}


public class Main {
    public static void main(String[] args) {
        Student student = new Student("Devendra");
        student.getGradeReport().setGrade("A+");
        System.out.println(student);
        System.out.println(student.getGradeReport());

    }
}
