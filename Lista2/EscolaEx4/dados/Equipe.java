package dados;

import java.util.*;

public class Equipe<T> {
    private String nome;
    private List<T> membros = new ArrayList<>();

    public Equipe(String nome) {
        this.nome = nome;
    }

    public void adicionarMembro(T membro) {
        membros.add(membro);
    }

    @Override
    public String toString() {
        String resultado = "Equipe: " + nome + "\nMembros:\n";
        for (T membro : membros) {
            resultado += " - " + membro.toString() + "\n";
        }
        return resultado;
    }
}
