package practice.midterm.OneToOne;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Max",26,890);
        System.out.println(p.getPassport().getPassportNumber());
        System.out.println(p);
        System.out.println(p.getPassport());
    }
}
