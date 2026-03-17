package Pratica1;

import java.util.Scanner;

public class Ex2 {
    public static void main (String[] args) {
        Scanner leitor = new Scanner(System.in);

        String[] name = new String[5];
        int[] years = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Escreva o nome e idade da pessoa numero " + (i+1) + ":");
            name[i] = leitor.nextLine();
            years[i] = leitor.nextInt();

            leitor.nextLine();
        }

        String nameTemp = " ";
        int idadeTemp = -10;
        int pos = -10;
        
        String[] nomesnovo = new String[5];
        int[] idadesnovo = new int[5];

        for (int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if (idadeTemp < years[j]) {
                    idadeTemp = years[j];
                    nameTemp = name[j];
                    pos = j;
                }
            }
            years[pos] = -20;
            idadesnovo[i] = idadeTemp;
            nomesnovo[i] = nameTemp;

            idadeTemp = -10;
            
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(nomesnovo[i] + " " + idadesnovo[i]);
        }

        leitor.close();
    }
}
