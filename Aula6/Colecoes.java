package Aula6;
import java.util.*;

public class Colecoes {
    public static List<Integer> tabuada (int n) {

        List<Integer> tabuada = new ArrayList<Integer>();
        
        for (int i = 1; i <= 10; i++) {
            tabuada.add( i * n);
        }
        return tabuada;
    }

    public static void main (String[] args) {
        Map<Integer, List<Integer>> todaTabuada = new HashMap<Integer, List<Integer>>();

        for (int i = 1; i <= 10; i++) {
            todaTabuada.put(i, tabuada(i));
        }

        for (List<Integer> numero : todaTabuada.values()) {
            System.out.println(numero);
        }
    }
}
