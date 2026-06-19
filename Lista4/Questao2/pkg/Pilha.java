package pkg;

import java.util.ArrayList;
import java.util.List;

public class Pilha<T> {
    private int limite;
    private List<T> elementos;

    public Pilha(int limite) {
        this.limite = limite;
        this.elementos = new ArrayList<>();
    }

    public void inserir(T objeto) throws PilhaCheiaException {
        if (elementos.size() >= limite) {
            throw new PilhaCheiaException();
        }
        elementos.add(objeto);
    }

    public T remover() throws PilhaVaziaException {
        if (elementos.isEmpty()) {
            throw new PilhaVaziaException();
        }
        return elementos.remove(elementos.size() - 1);
    }

    public int getSize() {
        return elementos.size();
    }
}