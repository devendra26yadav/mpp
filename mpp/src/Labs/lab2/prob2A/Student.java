package Labs.lab2.prob2A;

class Student {
    private String name;
    private GradeReport gradeReport;

    Student(String name) {
        this.name = name;
        gradeReport = new GradeReport(this);
    }

    public GradeReport getGradeReport() {
        return gradeReport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " : " + gradeReport;
    }
}
