package controller;

import model.ProjectClient;
import repository.ProjectClientRepository;

import java.util.List;

public class ProjectClientController {

    private final ProjectClientRepository repository = new ProjectClientRepository();

    public void addProjectClient(ProjectClient pc) {
        repository.create(pc);
    }

    public void getAllProjectClients() {
        List<ProjectClient> pcs = repository.getAll();
        if (pcs.isEmpty()) {
            System.out.println("No ProjectClient records found.");
        } else {
            System.out.println("Project Clients");
            pcs.forEach(System.out::println);
        }
    }

    public ProjectClient getProjectClient(int projectId, int clientId) {
        return repository.getById(projectId, clientId);
    }

    public void deleteProjectClient(int projectId, int clientId) {
        repository.delete(projectId, clientId);
    }
}
