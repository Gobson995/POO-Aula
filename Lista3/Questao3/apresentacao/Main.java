package apresentacao;

import dados.Digrafo;
import dados.Grafo;

public class Main {
    public static void main(String[] args) {
        Digrafo digrafo = new Digrafo();
        digrafo.adicionarVertice(); 
        digrafo.adicionarVertice(); 
        digrafo.adicionarVertice(); 
        digrafo.adicionarVertice(); 

        digrafo.adicionarAresta(0, 1);
        digrafo.adicionarAresta(0, 2);
        digrafo.adicionarAresta(2, 3);
        digrafo.adicionarAresta(3, 1);

        System.out.println("=== DÍGRAFO (Não Simétrico) ===");
        System.out.println(digrafo.toString());

        Grafo grafo = new Grafo();
        grafo.adicionarVertice(); 
        grafo.adicionarVertice(); 
        grafo.adicionarVertice(); 
        grafo.adicionarVertice(); 

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 1);

        System.out.println("=== GRAFO (Simétrico) ===");
        System.out.println(grafo.toString());
    }
}
