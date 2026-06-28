import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static List<Integer> tabuada(int n) {
        List<Integer> listaTabuada = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            listaTabuada.add(i * n);
        }

        return listaTabuada;
    }

    public static void main (String[] args) {
        Map<Integer, List<Integer>> todasAsTabuadas = new HashMap<>();

        for (int i = 1; i <= 10; i++) {
            todasAsTabuadas.put(i, tabuada(i));
        }
    }
}