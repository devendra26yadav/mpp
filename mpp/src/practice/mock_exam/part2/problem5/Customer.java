package practice.mock_exam.part2.problem5;
import java.util.Vector;

public class Customer {
    private String name;
    private int id;
    private Vector<Service> services;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
        this.services = new Vector<>();
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void removeService(Service service) {
        services.remove(service);
    }

    public int totalFee() {
        int total = 0;
        for (Service service : services) {
            total += service.calcFee();
        }
        return total;
    }
}
