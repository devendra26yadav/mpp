package Labs_solutions.lab11part2;

import java.util.List;
import java.util.Objects;

public class Student {

    public int id;
    public String name;
    public List<Double> grades;
    public List<Section> sections;
    public Address address;


    public Student(int id, String name, List<Double> grades, Address address) {
        this.id = id;
        this.name = name;
        this.grades = grades;
        this.address = address;
    }

    public Student(int id, String name, List<Double> grades, Address address, List<Section> sections) {
        this.id = id;
        this.name = name;
        this.grades = grades;
        this.address = address;
        this.sections = sections;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(grades, student.grades) && Objects.equals(sections, student.sections) && Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, grades, sections, address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public List<Section> getSections() {
        return sections;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public Address getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }
}
