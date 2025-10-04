package practice.mock_exam.part2.problem4;

public class Main {
    public static void main(String[] args) {
        Apartment apt1 = new Apartment(1000);
        Apartment apt2 = new Apartment(1500);
        Apartment apt3 = new Apartment(1200);

        Building building1 = new Building("H1");
        building1.addApartment(apt1);
        building1.addApartment(apt2);

        Building building2 = new Building("B2");
        building2.addApartment(apt3);

        Owner owner = new Owner("Max", "654-937-8934");
        owner.addBuilding(building1);
        owner.addBuilding(building2);

        System.out.println("Total Rent for Owner: " + owner.getRent());
    }
}
