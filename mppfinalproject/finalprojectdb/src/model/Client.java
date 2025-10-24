package model;
import java.util.List;

public class Client {
    private int id;
    private String name;
    private String industry;
    private String contactPersonName;
    private String contactPhone;
    private String contactEmail;

    // Relationships
    private List<Project> projects;

    public Client() {}

    public Client(int id, String name, String industry, String contactPersonName, String contactPhone, String contactEmail) {
        this.id = id;
        this.name = name;
        this.industry = industry;
        this.contactPersonName = contactPersonName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }

    public String getContactPersonName() { return contactPersonName; }
    public void setContactPersonName(String contactPersonName) { this.contactPersonName = contactPersonName; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public List<Project> getProjects() { return projects; }
    public void setProjects(List<Project> projects) { this.projects = projects; }

    @Override
    public String toString() {
        return "Client{id=" + id + ", name='" + name + "', industry='" + industry + "'}";
    }
}
