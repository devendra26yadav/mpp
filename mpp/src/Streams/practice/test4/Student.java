package Streams.practice.test4;

import java.util.List;

class Student {
    private int id;
    private String name;
    private List<Double> grades;
    private Address address;
    private List<Section> sections;

    public Student(int id, String name, List<Double> grades, Address address, List<Section> sections) {
        this.id = id;
        this.name = name;
        this.grades = grades;
        this.address = address;
        this.sections = sections;
    }

    public String getName() {
        return name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public Address getAddress() {
        return address;
    }

    public List<Section> getSections() {
        return sections;
    }

    @Override
    public String toString() {
        return name + " (Courses: " + (sections != null ? sections.size() : 0) + ")";
    }
}
