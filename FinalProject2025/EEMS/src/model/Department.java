package model;

//Justification: Represents organizational units.
public class Department {
    private int id;
    private String name;
    private String location;
    private double annualBudget;

    // Constructor
    public Department(int id, String name, String location, double annualBudget) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.annualBudget = annualBudget;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getAnnualBudget() { return annualBudget; }
    public void setAnnualBudget(double annualBudget) { this.annualBudget = annualBudget; }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", annualBudget=" + annualBudget +
                '}';
    }
}
