package practice.problems.problem1;
import java.util.*;

class University {
    private String name;
    private List<Department> departments = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public void addDepartment(Department d) {
        departments.add(d);
    }
}

class Department {
    private String name;
    private List<Professor> professors = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addProfessor(Professor p) {
        professors.add(p);
    }
}

class Professor {
    private String name;
    private Office office; // composition

    public Professor(String name, String officeRoom) {
        this.name = name;
        this.office = new Office(officeRoom);
    }
}

class Office {
    private String roomNo;

    public Office(String roomNo) {
        this.roomNo = roomNo;
    }
}

class Student {
    private String name;
    private Department department;   // association
    private List<Course> courses = new ArrayList<>();

    public Student(String name, Department dept) {
        this.name = name;
        this.department = dept;
    }

    public void enroll(Course c) {
        courses.add(c);
    }

    // dependency example
    public void borrowBook(Library library, String bookTitle) {
        library.lendBook(this, bookTitle);
    }

    public String getName() {
        return name;
    }
}

class Course {
    private String title;
    private Professor professor;  // association

    public Course(String title, Professor prof) {
        this.title = title;
        this.professor = prof;
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    public void lendBook(Student s, String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                System.out.println("Library lends '" + title + "' to " + s.getName());
                return;
            }
        }
        System.out.println("Book not found!");
    }
}

class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() { return title; }
}

// Main driver
public class UniversitySystem {
    public static void main(String[] args) {
        University uni = new University("MyUniversity");

        Department cs = new Department("Computer Science");
        Department math = new Department("Mathematics");
        uni.addDepartment(cs);
        uni.addDepartment(math);

        Professor prof1 = new Professor("Dr. Smith", "Room101");
        cs.addProfessor(prof1);

        Course javaCourse = new Course("Java Programming", prof1);

        Student s1 = new Student("Alice", cs);
        s1.enroll(javaCourse);

        Library library = new Library();
        library.addBook(new Book("Data Structures"));
        library.addBook(new Book("Java Basics"));

        s1.borrowBook(library, "Java Basics");
    }
}
