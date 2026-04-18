import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pessoa> listaGeral = new ArrayList<>();

        while (true) {
            System.out.println("Digite a idade ou -1 para sair: ");
            int idade = sc.nextInt();
            sc.nextLine();

            if (idade == -1) break;

            System.out.print("Digite o nome: ");
            String nome = sc.nextLine();
            System.out.print("Digite o CPF: ");
            String cpf = sc.nextLine();
            System.out.print("Digite a cidade: ");
            String cidade = sc.nextLine();

            listaGeral.add(new Pessoa(nome, idade, cpf, cidade));

            Collections.sort(listaGeral);

            exibirRelatorio(listaGeral);
        }

        System.out.println("Programa encerrado...");

        sc.close();
    }

    private static void exibirRelatorio(List<Pessoa> pessoas) {
        System.out.println("\n Lista de pessoas por faixa etária");

        imprimirFaixa(pessoas, "Crianças (1 até 12 anos)", 1, 12);
        imprimirFaixa(pessoas, "Adolescentes (13 até 18 anos)", 13, 18);
        imprimirFaixa(pessoas, "Jovens (19 até 25 anos)", 19, 25);
        imprimirFaixa(pessoas, "Adultos (26 até 59 anos)", 26, 59);
        imprimirFaixa(pessoas, "Idosos (60 anos ou mais)", 60, 200);
    }

    private static void imprimirFaixa(List<Pessoa> lista, String titulo, int min, int max) {
        boolean vazio = false;

        for (Pessoa p : lista) {
            if (p.getIdade() >= min && p.getIdade() <= max) {
                if (!vazio) {
                    System.out.println(titulo + ":");
                    vazio = true;
                }
                System.out.println(" " + p.toString());
            }
        }
    }
}
