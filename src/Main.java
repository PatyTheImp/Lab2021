import java.util.Scanner;
import java.io.*;

public class Main {
    //private static final String INPUT_FILE = "K:\\OneDrive\\faculdade\\primeiro_semestre\\ip\\aulas_P\\Lab2021\\src\\labVersaoA-1.txt";
    private static final String INPUT_FILE = "K:\\OneDrive\\faculdade\\primeiro_semestre\\ip\\aulas_P\\Lab2021\\src\\labVersaoA-2.txt";
    //private static final String OUTPUT_FILE = "K:\\OneDrive\\faculdade\\primeiro_semestre\\ip\\aulas_P\\Lab2021\\src\\labOutputVA-1.txt";
    private static final String OUTPUT_FILE = "K:\\OneDrive\\faculdade\\primeiro_semestre\\ip\\aulas_P\\Lab2021\\src\\labOutputVA-2.txt";

    public static void main(String[] args)  {
        try {
            Project project = readFromFile(INPUT_FILE);
            writeToFile(OUTPUT_FILE, project);
        } catch (FileNotFoundException e) {
            System.out.println("Erro nos ficheiros");
        }
    }

    private static Project readFromFile(String fileName) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(fileName));
        int id = in.nextInt();
        in.nextLine();
        String bidder = in.nextLine().trim();
        String description = in.nextLine().trim();
        int maxCollaborators = in.nextInt();
        in.nextLine();
        Project project = new Project(id, description, bidder, maxCollaborators);
        int effectiveCollaborators = in.nextInt();
        in.nextLine();
        for (int i = 0;  i < effectiveCollaborators; i++)
            project.addCollaborator(in.nextLine().trim());
        in.close();
        return project;
    }

    private static void writeToFile(String fileName, Project project) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileName);
        CollaboratorsIterator it = project.iterator();
        while (it.hasNext()) {
            out.printf("%s\n", it.next());
        }
        out.close();
    }
}

























