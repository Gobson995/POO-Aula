import java.io.*;
import java.util.Scanner;

public class Transcritor {
    public static void main (String[] args) throws IOException {
        Reader r = new FileReader("entrada.txt");
        Scanner sc = new Scanner(r);

        Writer w = new FileWriter("saida.txt");
        BufferedWriter bw = new BufferedWriter(w);

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            bw.write(s);
            bw.newLine();
        }

        sc.close();
        r.close();
        bw.close();
    }
}
