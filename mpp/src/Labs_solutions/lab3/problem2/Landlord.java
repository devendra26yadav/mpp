package Labs_solutions.lab3.problem2;

import java.util.ArrayList;
import java.util.List;

public class Landlord {
    private final String name;
    private List<Building> buildings;
    public Landlord(String name){
        this.name=name;
        buildings = new ArrayList<>();
        addBuilding(new Building(100,250));
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public double getMonthlyProfit() {
        double profit = 0;
        for (Building building : buildings) {
            System.out.println(building);
             System.out.println("Profit : "+building.getProfit());
            profit += building.getProfit();
        }
        return profit;
    }
}
