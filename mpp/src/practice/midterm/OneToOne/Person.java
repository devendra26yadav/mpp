package practice.midterm.OneToOne;

public class Person {
    private String name;
    private int age;
    private Passport passport;

    Person(String name, int age, int passportNumber) {
        this.name = name;
        this.age = age;
        passport = new Passport(passportNumber, this);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Passport getPassport() {
        return passport;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", passport=" + passport.getPassportNumber() + "}";
    }

}
