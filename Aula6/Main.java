package Aula6;

import java.util.*;

public class Main {
    public static void main (String[] args) {

        List<String> listaStrings = new ArrayList<String>();

        listaStrings.add("Gustavo");
        listaStrings.add("Vinicius");
        listaStrings.add("Manoel");
        listaStrings.add("Lucas");
        listaStrings.add("Baldo");

        for (String s : listaStrings) {
            System.out.println(s);
        }
    }
}
