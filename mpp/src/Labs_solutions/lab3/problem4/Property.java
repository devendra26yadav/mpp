package Labs_solutions.lab3.problem4;

public abstract class Property {
    protected Address address;

    public Property(Address address) {
        this.address = address;
    }

    public abstract double getRent();

    @Override
    public String toString() {
        return address.toString();
    }
}
