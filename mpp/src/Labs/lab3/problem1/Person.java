package Labs.lab3.problem1;

import java.util.Objects;

public class Person {
    private String name;
    Person(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o){
        if(o==null) return false;
        if(!(o instanceof Person)) return false;
        Person p = (Person) o;
        return this.name.equals(p.name);
    }

    public static void main(String[] args) {

    }

}