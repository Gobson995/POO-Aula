import java.io.*;
import java.util.*;

public class LendoChar {
    public static void main (String[] args) throws IOException {
        Reader r = new FileReader("arquivo.txt");
        char c = (char) r.read();
        System.out.println(c);
        r.close();
    }

}