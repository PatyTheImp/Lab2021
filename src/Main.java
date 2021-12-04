import java.util.Scanner;
import java.io.*;

public class Main {
    //private static final String INPUT_FILE = "K:\\OneDrive\\faculdade\\primeiro_semestre\\ip\\aulas_P\\Lab2021\\src\\labVersaoC-1.txt";
    private static final String INPUT_FILE = "K:\\OneDrive\\faculdade\\primeiro_semestre\\ip\\aulas_P\\Lab2021\\src\\labVersaoC-2.txt";
    //private static final String OUTPUT_FILE = "K:\\OneDrive\\faculdade\\primeiro_semestre\\ip\\aulas_P\\Lab2021\\src\\labOutputVC-1.txt";
    private static final String OUTPUT_FILE = "K:\\OneDrive\\faculdade\\primeiro_semestre\\ip\\aulas_P\\Lab2021\\src\\labOutputVC-2.txt";

    public static void main(String[] args)  {
        try {
            Scanner in = new Scanner(new FileReader(INPUT_FILE));
            Lab lab = new Lab(in);
            int numOfNewCollabs = in.nextInt();
            in.nextLine();
            for (int i = 0; i < numOfNewCollabs; i++)
                lab.addCollabToProject(in);
            lab.writeToFile(OUTPUT_FILE, in);
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro nos ficheiros");
        }
    }
}

























