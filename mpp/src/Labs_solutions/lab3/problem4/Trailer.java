package Labs_solutions.lab3.problem4;

public class Trailer extends Property {
    private final double rent = 500;
    public Trailer(Address address) {
        super(address);
    }

    @Override
    public double getRent() {
        return rent;
    }
}
