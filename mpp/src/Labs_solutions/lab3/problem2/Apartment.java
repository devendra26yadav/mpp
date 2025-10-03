package Labs_solutions.lab3.problem2;

public class Apartment {
    private String apartmentName;
    private double rent;

    public Apartment(String apartmentName, double rent) {
        this.apartmentName = apartmentName;
        this.rent = rent;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public double getRent() {
        return rent;
    }

    @Override
    public String toString() {
        return "Name: " + apartmentName + " Rent: " + rent;
    }
}
