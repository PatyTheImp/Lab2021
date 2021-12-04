import java.util.Scanner;
import java.io.*;

public class Lab {
    private Project[] projects;
    private int size;

    public Lab(String fileName) {
        projects = new Project[1];
        this.size = 0;
    }

    /** Pre: size < projects.length() */
    private void addProject(Project project) {
        projects[size++] = project;
    }
}
