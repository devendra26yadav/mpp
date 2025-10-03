package Labs_solutions.lab3.problem4;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    public static double computeTotalRent(Property[] properties) {
        if (properties == null) return 0;
        double totalRent = 0;
        for (Property p : properties) {
            totalRent += p.getRent();
        }
        return totalRent;
    }

    public static List<Property> findByCity(Property[] properties, String byCity) {
        if(properties==null || byCity==null) return null;
        List<Property> propertyByCity = new ArrayList<>();
        for (Property p : properties) {
            if (p.address.getCity().equals(byCity)) {
                propertyByCity.add(p);
            }
        }
        return propertyByCity;
    }
}
