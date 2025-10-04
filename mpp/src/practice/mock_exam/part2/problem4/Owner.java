package practice.mock_exam.part2.problem4;

import java.util.ArrayList;
import java.util.List;

public class Owner {
    private String name;
    private String telephone;
    private List<Building> buildings;

    public Owner(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
        this.buildings = new ArrayList<>();
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public double getRent() {
        double total = 0;
        for (Building building : buildings) {
            total += building.getRent();
        }
        return total;
    }
}
