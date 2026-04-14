package apresentacao;

import java.util.*;
import dados.Contato;
import negocio.ListaTelefonica;

public class Main {
    private static ListaTelefonica listaTelefonica = new ListaTelefonica();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\nLISTA TELEFÔNICA");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Remover Contato");
            System.out.println("3. Exibir Todos os Contatos");
            System.out.println("4. Exibir Contatos por Letra");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    removerContato();
                    break;
                case 3:
                    exibirContatos();
                    break;
                case 4:
                    System.out.print("Digite a letra desejada: ");
                    char letra = scanner.nextLine().charAt(0);
                    exibirContatos(letra);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static Contato novoContato() {
        Contato c = new Contato();
        System.out.print("Digite o nome: ");
        c.setNome(scanner.nextLine());
        System.out.print("Digite o telefone: ");
        c.setTelefone(scanner.nextLine());
        return c;
    }

    private static void adicionarContato() {
        Contato c = novoContato();
        listaTelefonica.adicionarContato(c);
        System.out.println("Contato adicionado com sucesso!");
    }

    public static void removerContato() {
        exibirContatos(); 

        System.out.println("\nREMOVER CONTATO");
        System.out.println("Digite exatamente o nome e telefone do contato:");
        Contato c = novoContato();
        
        listaTelefonica.removerContato(c);
        System.out.println("Comando de remoção processado.");
    }

    public static void exibirContatos() {
        Map<Character, List<Contato>> mapa = listaTelefonica.buscarContatos();

        System.out.println("\nTODOS OS CONTATOS");
        
        for (Character letra : mapa.keySet()) {
            List<Contato> lista = mapa.get(letra);

            if (lista.isEmpty()) {
                System.out.println("Letra " + letra + ": (vazio)");
            } else {
                System.out.println("Letra " + letra + ":");
                for (Contato c : lista) {
                    System.out.println("  -> Nome: " + c.getNome() + " | Tel: " + c.getTelefone());
                }
            }
        }
    }

    public static void exibirContatos(char letra) {
        List<Contato> lista = listaTelefonica.buscarContatos(letra);

        if (lista != null && !lista.isEmpty()) {
            System.out.println("\n--- Encontrados na Letra " + Character.toUpperCase(letra) + " ---");
            for (Contato c : lista) {
                System.out.println("  -> Nome: " + c.getNome() + " | Tel: " + c.getTelefone());
            }
        } else {
            System.out.println("Nenhum contato encontrado nesta letra.");
        }
    }
}