package Streams.practice.test4;

class Section {
    private String courseCode;

    public Section(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    @Override
    public String toString() {
        return courseCode;
    }
}