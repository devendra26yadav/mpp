package model;

public class ProjectClient {
    private int projectId;
    private int clientId;

    private Project project;
    private Client client;

    public ProjectClient() {}

    public ProjectClient(int projectId, int clientId) {
        this.projectId = projectId;
        this.clientId = clientId;
    }

    // Getters and Setters
    public int getProjectId() { return projectId; }
    public void setProjectId(int projectId) { this.projectId = projectId; }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
}
