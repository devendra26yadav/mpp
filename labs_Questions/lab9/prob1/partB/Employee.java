package Labs_solutions.lab9.prob1.partB;

public class Employee {
    private String name;
    private int salary;
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
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

    @Override
    public boolean equals(Object o){
        if(o==null) return false;
        if(!( o instanceof Employee e)) return false;
        return name.equals(e.name) && salary==e.salary;
    }



//    public boolean equals(Employee e) {
//        return e.name.equals(name) && e.salary == salary;
//    }
//	public boolean equals(Object ob) {
//		Employee e = (Employee)ob;
//		return e.name.equals(name) && e.salary == salary;
//	}
}