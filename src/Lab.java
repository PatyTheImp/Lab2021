import java.util.Scanner;
import java.io.*;

public class Lab {
    private Project[] projects;
    private int size;

    public Lab(String fileName) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(fileName));
        int numOfProjects = in.nextInt();
        in.nextLine();
        projects = new Project[numOfProjects];
        this.size = 0;
        for (int i = 0; i < numOfProjects; i++)
            addProject(getProjectFromFile(in));
        in.close();
    }

    public ProjectIterator iterator() {
        sort();
        return new ProjectIterator(projects, size);
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













