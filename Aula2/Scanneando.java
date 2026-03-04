package Aula2;

import java.util.Scanner;

public class Scanneando {
    public static void main (String[] args) {
        Scanner scanTeclado = new Scanner (System.in);

        System.out.println("Digite o seu sobrenome:");

        String sobrenome = scanTeclado.nextLine(); // nextLine espera uma strig
        System.out.println("Você pertence a familia: " + sobrenome);

        scanTeclado.close();
    }
}
