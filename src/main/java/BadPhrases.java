import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BadPhrases {
    String phrase;
    private static final String filePath = "\\\\10.0.0.200\\dane_multimedia\\Hubert\\obrazkiTest\\badPhrases.txt";

    public static List loadBadPhrases() throws IOException {

        File file = new File(filePath);
        String string;

        List list = new ArrayList();

        BufferedReader fr = new BufferedReader(new FileReader(file));
        while ((string = fr.readLine()) != null) {
            list.add(string);
        }
        System.out.println(list);
        return list;
    }

    public static void addBadPhrase() throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file = new File(filePath);
        BufferedWriter wr = new BufferedWriter(new FileWriter(file, true));
        wr.append("\n" + scanner.next());
        wr.close();
    }

    public static void printBadPhrases(){

    }
}
