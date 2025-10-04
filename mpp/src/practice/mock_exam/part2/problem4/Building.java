package practice.mock_exam.part2.problem4;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private String buildingNumber;
    private List<Apartment> apartments;

    public Building(String buildingNumber) {
        this.buildingNumber = buildingNumber;
        this.apartments = new ArrayList<>();
    }

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }

    public double getRent() {
        double total = 0;
        for (Apartment apartment : apartments) {
            total += apartment.getRent();
        }
        return total;
    }
}
