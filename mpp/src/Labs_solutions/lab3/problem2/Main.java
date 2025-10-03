package Labs_solutions.lab3.problem2;

public class Main {
    public static void main(String[] args) {
        Apartment a1 = new Apartment("A",300);
        Apartment a2 = new Apartment("B",500);
        Apartment a3 = new Apartment("C",600);

        Building building1 = new Building(1,100);
        building1.addApartment(a1);
        building1.addApartment(a2);
        building1.addApartment(a3);

        Apartment[] apartments2 = {
                new Apartment("AA",700),
                new Apartment("AB",750),
                new Apartment("AC",800),
                new Apartment("AD",850),
        };
        Building building2 = new Building(2,500);
        for(Apartment a:apartments2){
            building2.addApartment(a);
        }

        Landlord landlord = new Landlord("Maike");
        landlord.addBuilding(building1);
        landlord.addBuilding(building2);

        System.out.println("Monthly Profit : "+landlord.getMonthlyProfit());
    }
}
