package apresentacao;

import dados.*;
import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Numeros Naturais");
            System.out.println("2 - Numeros Abundantes");
            System.out.println("3 - Numeros Fatoriais");
            System.out.println("4 - Sequencia de Fibonacci");
            System.out.println("5 - Numeros Primos");
            System.out.println("6 - Quadrados Perfeitos");
            System.out.println("7 - Numeros Perfeitos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            int opcao = sc.nextInt();

            if (opcao == 0) {
                System.out.println("Encerrando o programa...");
                break;
            }

            if (opcao < 1 || opcao > 7) {
                System.out.println("Opcao invalida! Tente novamente.");
                continue;
            }

            System.out.print("Quantos numeros voce deseja gerar? ");
            int quantidade = sc.nextInt();

            Gerador gerador = null;

            switch (opcao) {
                case 1: gerador = new Naturais(); break;
                case 2: gerador = new Abundantes(); break;
                case 3: gerador = new Fatoriais(); break;
                case 4: gerador = new Fibonacci(); break;
                case 5: gerador = new Primos(); break;
                case 6: gerador = new Quadrados(); break;
                case 7: gerador = new Perfeitos(); break;
            }

            if (gerador != null) {
                gerador.gerar(quantidade);
                System.out.print("\nResultado: ");
                imprimirSequencia(gerador.getSequencia());
                System.out.println(); // Pula linha no final
            }
        }
        
        sc.close();

    }

    public static void imprimirSequencia(List<Integer> sequencia) {
        sequencia.forEach(
            (valor) -> {
                System.out.print(valor + " ");
            }
        );
    }
}
