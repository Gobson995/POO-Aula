package Aula3;

import java.util.Scanner;

public class Exercicio1 {
    public static void main (String[] args) {

        Scanner leitor = new Scanner(System.in);

        int[] valores = new int[5];

        int total = 0;

        float media;

        System.out.println("Escreva os 5 valores: ");

        for (int i = 0; i < 5; i++) {
            valores[i] = leitor.nextInt();
            total += valores[i];
        }

        media = total / 5.0f;

        System.out.println("A média dos 5 valores é: " + media);

        leitor.close();
     }
}
