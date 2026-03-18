package Pratica1;

import java.util.Scanner;

public class Ex1 {
    public static void main (String[] args) {

        Scanner leitor = new Scanner(System.in);

        int[] valor = new int[5];

        float media = 0;

        System.out.println("Escreva os 5 valores: ");

        for (int i = 0; i < 5; i++) {
            valor[i] = leitor.nextInt();
            media += valor[i];
        }

        media /= 5.0;

        System.out.println("A média dos 5 valores é: " + media);

        leitor.close();
     }
}