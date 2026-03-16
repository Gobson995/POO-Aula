package Aula3;

import java.util.*;

public class Exercicio2 {
    public static void main (String[] args) {
        Scanner leitor = new Scanner(System.in);

        String[] nomes = new String[5];
        int[] idades = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Escreva o nome e idade da pessoa numero " + (i+1) + ":");
            nomes[i] = leitor.nextLine();
            idades[i] = leitor.nextInt();

            leitor.nextLine();
        }

        String nomeTemp = " ";
        int idadeTemp = -1;
        int pos = -1;
        
        String[] nomesnovo = new String[5];
        int[] idadesnovo = new int[5];

        for (int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if (idadeTemp < idades[j]) {
                    idadeTemp = idades[j];
                    nomeTemp = nomes[j];
                    pos = j;
                }
            }
            idades[pos] = -2;
            idadesnovo[i] = idadeTemp;
            nomesnovo[i] = nomeTemp;

            idadeTemp = -1;
            
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(idadesnovo[i] + " " + nomesnovo[i]);
        }

        leitor.close();
    }
}
