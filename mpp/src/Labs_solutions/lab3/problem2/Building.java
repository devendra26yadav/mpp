package Labs.lab3.problem2;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private final int buildingNumber;
    private final double maintenanceCost;
    private List<Apartment> apartments;

    public Building(int buildingNumber, double maintenanceCost) {
        this.buildingNumber = buildingNumber;
        this.maintenanceCost = maintenanceCost;
        apartments = new ArrayList<>();
        addApartment(new Apartment("Basement",300));
    }

    public void addApartment(Apartment apartment) {
        if (apartment == null) return;
        apartments.add(apartment);
    }

    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public double getProfit() {
        double profit = 0;
        for (Apartment apartment : apartments) {
            profit += apartment.getRent();
        }
        return profit - maintenanceCost;
    }

    @Override
    public String toString() {
        return "Building : " + buildingNumber;
    }
}
