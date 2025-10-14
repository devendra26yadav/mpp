package Labs_solutions.lab9.prob1.partD;


import java.util.Objects;

public class Employee {
    private String name;
    private int salary;
    private boolean visited = false;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setVisited(boolean b) {
        visited = b;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + salary + ")";
    }

    // given overridden method
//    @Override
//    public boolean equals(Object ob) {
//        if(ob == null) return false;
//        if(!(ob instanceof Employee)) return false;
//        Employee emp = (Employee)ob;
//        return emp.name.equals(name) && emp.salary == salary && emp.visited == visited;
//    }

    // given overridden method
//    @Override
//    public int hashCode() {
//        int result = 17;
//        long longval = Double.doubleToLongBits(salary);
//        int salaryHash = (int) (longval ^ (longval >>> 32));
//        result += 31 * result + name.hashCode();
//        result += 31 * result + salaryHash;
//        result += 31 * result + (visited ? 1 : 0);
//        //result += 31 * result + (visited ? 71 : 43);
//        return result;
//    }

    // fixed by me
    @Override
    public boolean equals(Object o){
        if(o==null) return false;
        if(!(o instanceof Employee e)) return false;
        return name.equals(e.name) && salary==e.salary;
    }
    // fixed by me
    @Override
    public int hashCode(){
        return Objects.hash(name,salary);
    }
}
