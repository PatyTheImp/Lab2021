import java.util.Scanner;
import java.io.*;

public class Main {
    private static final String INPUT_FILE = "K:\\OneDrive\\faculdade\\primeiro_semestre\\ip\\aulas_P\\Lab2021\\src\\labVersaoB-1.txt";
    //private static final String INPUT_FILE = "K:\\OneDrive\\faculdade\\primeiro_semestre\\ip\\aulas_P\\Lab2021\\src\\labVersaoB-2.txt";
    private static final String OUTPUT_FILE = "K:\\OneDrive\\faculdade\\primeiro_semestre\\ip\\aulas_P\\Lab2021\\src\\labOutputVB-1.txt";
    //private static final String OUTPUT_FILE = "K:\\OneDrive\\faculdade\\primeiro_semestre\\ip\\aulas_P\\Lab2021\\src\\labOutputVB-2.txt";

    public static void main(String[] args)  {
        try {
            Lab lab = new Lab(INPUT_FILE);
            writeToFile(OUTPUT_FILE, lab);
        } catch (FileNotFoundException e) {
            System.out.println("Erro nos ficheiros");
        }
    }

    private static void writeToFile(String fileName, Lab lab) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileName);
        ProjectIterator it = lab.iterator();
        while (it.hasNext()) {
            Project project = it.next();
            out.println(project.getId());
            out.println(project.getBidderEmail());
        }
        out.close();
    }
}

























