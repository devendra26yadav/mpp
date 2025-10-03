package Labs.lab3.problem4;

public class House extends Property {
    private double lotSize;

    public House(Address address, double lotSize) {
        super(address);
        this.lotSize = lotSize;
    }

    public double getRent() {
        return 0.1 * lotSize;
    }
}
