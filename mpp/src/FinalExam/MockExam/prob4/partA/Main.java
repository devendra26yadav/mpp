package FinalExam.MockExam.prob4.partA;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("Zaineh",7000));
        emps.add(new Employee("Yasmeen",6000));
        emps.add(new Employee("Dean",3000));
        System.out.println(LambdaLibrary.netSalary.apply(emps));
    }
}
