package dados;

import java.util.ArrayList;
import java.util.List;

public class Digrafo {
    private List<List<Integer>> matrizAdjacencia;

    public Digrafo() {
        this.matrizAdjacencia = new ArrayList<>();
    }

    public void adicionarVertice() {
        int novoTamanho = matrizAdjacencia.size() + 1;

        for (List<Integer> linha : matrizAdjacencia) {
            linha.add(0);
        }

        List<Integer> novaLinha = new ArrayList<>();
        for (int i = 0; i < novoTamanho; i++) {
            novaLinha.add(0);
        }
        
        matrizAdjacencia.add(novaLinha);
    }

    public void adicionarAresta(int origem, int destino) {
        if (origem >= 0 && origem < matrizAdjacencia.size() && destino >= 0 && destino < matrizAdjacencia.size()) {
            matrizAdjacencia.get(origem).set(destino, 1);
        }
    }

    @Override
    public String toString() {
        String resultado = "  ";
        int tamanho = matrizAdjacencia.size();
        
        for (int i = 0; i < tamanho; i++) {
            resultado += i + " ";
        }
        resultado += "\n";

        for (int i = 0; i < tamanho; i++) {
            resultado += i + " ";
            for (int j = 0; j < tamanho; j++) {
                resultado += matrizAdjacencia.get(i).get(j) + " ";
            }
            resultado += "\n";
        }
        
        return resultado;
    }
}