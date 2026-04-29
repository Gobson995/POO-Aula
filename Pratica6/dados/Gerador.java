package dados;
import java.util.*;

public abstract class Gerador {
    protected List<Integer> sequencia = new ArrayList<>();

    public List<Integer> getSequencia() {
        return sequencia;
    }

    public abstract void gerar (int quantidade);
}
