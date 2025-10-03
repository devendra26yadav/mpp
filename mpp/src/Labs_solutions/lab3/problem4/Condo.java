package Labs_solutions.lab3.problem4;

public class Condo extends Property {
    private int numFloors;

    public Condo(Address address, int numFloors) {
        super(address);
        this.numFloors = numFloors;
    }

    @Override
    public double getRent() {
        return 400 * numFloors;
    }
}
