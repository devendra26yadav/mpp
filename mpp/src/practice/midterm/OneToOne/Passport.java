package practice.midterm.OneToOne;

public class Passport {
    private int passportNumber;
    private Person person;
    Passport(int passportNumber,Person person){
        this.passportNumber=passportNumber;
        this.person=person;
    }

    public int getPassportNumber() {
        return passportNumber;
    }
    public Person getPerson(){
        return person;
    }
    @Override
    public String toString(){
        return "Passport{name:"+person.getName()+" age: "+person.getAge()+" passportNUmber : "+passportNumber+"}";
    }
}
