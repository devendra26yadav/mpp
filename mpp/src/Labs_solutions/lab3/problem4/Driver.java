package Labs.lab3.problem4;

public class Driver {
    public static void main(String[] args) {

        Property[] objects = {
                new House(new Address("Maple St", "Springfield", "IA", "53425"), 9000),
                new Condo(new Address("Birch Blvd", "Fairfield", "IA", "54425"), 2),
                new Trailer(new Address("North St", "Springfield", "LA", "90425")),
                new Condo(new Address("Pine Rd", "Shelbyville", "IA", "53475"), 4),
        };
        double totalRent = Admin.computeTotalRent(objects);
        System.out.println("Total Rent : "+totalRent);

        String city = "Springfield";
        System.out.println("Property By City : " + city);

        for (Property p : Admin.findByCity(objects, city)) {
            System.out.println(p);
        }
    }
}
