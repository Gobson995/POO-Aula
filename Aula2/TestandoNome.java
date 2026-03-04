package Aula2;

import java.util.*;

public class TestandoNome {
    public static void main (String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = teclado.nextLine();

        System.out.println("Opa, " + nome + ". Quantos anos você tem?");

        try {
            int idade = teclado.nextInt(); // está esperando um inteiro para a idade
            if (idade >= 18) System.out.println("Você é maior de idade");
            else System.out.println("Você não é maior de idade");
        } catch (InputMismatchException e) {
            System.out.println("Você deveria ter digitado um número");    
        }

        teclado.close();
     }
}
