import java.io.*;
import java.util.Scanner;

public class Lab {
    private Project[] projects;
    private int size;

    public Lab(Scanner in) {
        int numOfProjects = in.nextInt();
        in.nextLine();
        projects = new Project[numOfProjects];
        this.size = 0;
        for (int i = 0; i < numOfProjects; i++)
            addProject(getProjectFromFile(in));
    }

    public ProjectIterator iterator() {
        sort();
        return new ProjectIterator(projects, size);
    }

    public void addCollabToProject(Scanner in) {
        int projectId = in.nextInt();
        in.nextLine();
        Project project = findProjectById(projectId);
        project.addCollaborator(in.nextLine().trim());
    }

    public void writeToFile(String fileName, Scanner in) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileName);
        ProjectIterator it = this.iterator();
        while (it.hasNext()) {
            Project project = it.next();
            out.println(project.getId());
            out.println(project.getBidderEmail());
        }
        int numOfOrds = in.nextInt();
        in.nextLine();
        for (int i = 0; i < numOfOrds; i++) {
            Project proj = findProjectById(in.nextInt());
            in.nextLine();
            CollaboratorsIterator collabIt = proj.iterator();
            while (collabIt.hasNext()) {
                out.println(collabIt.next());
            }
        }
        out.close();
    }

    private Project findProjectById(int projectId) {
        for (int i = 0; i < size; i++) {
            if (projects[i].getId() == projectId)
                return projects[i];
        }
        return null;
    }

    /** Pre: size < projects.length() */
    private void addProject(Project project) {
        projects[size++] = project;
    }

    private Project getProjectFromFile(Scanner in) {
        int id = in.nextInt();
        in.nextLine();
        String bidder = in.nextLine().trim();
        String description = in.nextLine().trim();
        int maxCollaborators = in.nextInt();
        in.nextLine();
        return new Project(id, description, bidder, maxCollaborators);
    }

    private void sort() {
        for (int i = 1; i < size; i++) {
            for (int j = size - 1; j >= i; j--) {
                if (projects[j].getId() < projects[j - 1].getId()) {
                    Project aux = projects[j];
                    projects[j] = projects[j - 1];
                    projects[j - 1] = aux;
                }
            }
        }
    }
}













