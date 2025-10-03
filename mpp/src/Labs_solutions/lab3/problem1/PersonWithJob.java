package Labs_solutions.lab3.problem1;

public class PersonWithJob{

    private double salary;
    private Person person;

    public double getSalary() {
        return salary;
    }
    PersonWithJob(Person person, double salary) {
       this.person=person;
       this.salary=salary;
    }

    @Override
    public boolean equals(Object o){
        if(o==null ) return false;
        if(!(o instanceof PersonWithJob pwj)) return false;
        return this.person.equals(pwj.person) && this.salary==pwj.salary;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Jack");
        PersonWithJob pwj1 = new PersonWithJob(new Person("Jack"),3000);
        System.out.println(p1.equals(pwj1));
        System.out.println(pwj1.equals(p1));
        PersonWithJob pwj2 = new PersonWithJob(new Person("Jack"),3000);
        System.out.println(pwj1.equals(pwj2));
        PersonWithJob pwj3 = new PersonWithJob(new Person("Jack"),2999);
        System.out.println(pwj2.equals(pwj3));

    }


}
