import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matriz<Integer> matriz = new Matriz<>(5, 5);

        System.out.println("Digite até 25 números para a matriz (ou -1 para parar): ");

        boolean parar = false;

        for (int i = 0; i < 5; i++) {
            if (parar) break;

            for (int j = 0; j < 5; j++) {
                int numero = scanner.nextInt();

                if (numero == -1) {
                    parar = true;
                    break;
                }

                matriz.set(numero, i, j);
            }
        }

        List<Integer> q1 = matriz.getElementosQuadrante(Quadrante.PRIMEIRO);
        List<Integer> q2 = matriz.getElementosQuadrante(Quadrante.SEGUNDO);
        List<Integer> q3 = matriz.getElementosQuadrante(Quadrante.TERCEIRO);
        List<Integer> q4 = matriz.getElementosQuadrante(Quadrante.QUARTO);

        int menorQ1 = buscarMenor(q1);
        int menorQ2 = buscarMenor(q2);
        int menorQ3 = buscarMenor(q3);
        int menorQ4 = buscarMenor(q4);

        int menorGeral = menorQ1;
        if (menorQ2 < menorGeral) menorGeral = menorQ2;
        if (menorQ3 < menorGeral) menorGeral = menorQ3;
        if (menorQ4 < menorGeral) menorGeral = menorQ4;

        if (menorGeral == Integer.MAX_VALUE) {
            System.out.println("A matriz ficou vazia!");
        }
        else {
            System.out.println("O menor elemento da matriz é: " + menorGeral);
        }

        scanner.close();
    }

    public static int buscarMenor(List<Integer> lista) {
        int menor = Integer.MAX_VALUE;

        for (Integer num : lista) {
            if (num != null && num < menor) {
                menor = num;
            }
        }
        return menor;
    }
}
