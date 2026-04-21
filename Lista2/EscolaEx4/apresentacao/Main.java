package apresentacao;

import dados.*;
import negocio.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Turma turma = new Turma();

        System.out.println("Sistema de Formação de Equipes");

        while (true) {
            System.out.print("Nome do aluno (ou -1 para encerrar): ");
            String nome = sc.nextLine();
            if (nome.equals("-1")) break;

            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            
            System.out.print("Idade: ");
            aluno.setIdade(Integer.parseInt(sc.nextLine()));

            double[] notas = new double[5];
            for (int i = 0; i < 5; i++) {
                System.out.print("Nota " + (i + 1) + ": ");
                notas[i] = Double.parseDouble(sc.nextLine());
            }
            aluno.setNotas(notas);
            
            turma.adicionarAluno(aluno);
        }

        System.out.println("\nFORMANDO EQUIPES EQUILIBRADAS");
        List<Equipe<Aluno>> resultado = turma.separarEmEquipes();

        for (Equipe<Aluno> eq : resultado) {
            System.out.println(eq.toString());
        }

        sc.close();
    }
    
}
