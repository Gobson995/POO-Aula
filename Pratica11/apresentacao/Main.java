package apresentacao;

import dados.Contato;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import negocio.ListaTelefonica;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha do banco de dados: ");
        String senha = scanner.nextLine();

        ListaTelefonica agenda;
        try {
            agenda = new ListaTelefonica(senha);
        } catch (ClassNotFoundException | SQLException | SelectException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            scanner.close();
            return;
        }

        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n========== AGENDA TELEFÔNICA ==========");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Listar Todos os Contatos");
            System.out.println("3 - Buscar Contato por Letra");
            System.out.println("4 - Remover Contato");
            System.out.println("5 - Atualizar Contato");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    try {
                        adicionar(agenda, scanner);
                    } catch (InsertException | SelectException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        listarTodos(agenda);
                    } catch (SelectException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        buscar(agenda, scanner);
                    } catch (SelectException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        remover(agenda, scanner);
                    } catch (DeleteException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        atualizar(agenda, scanner);
                    } catch (UpdateException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Saindo do sistema... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void adicionar(ListaTelefonica agenda, Scanner scanner) throws InsertException, SelectException {
        System.out.println("\n--- Novo Contato ---");
        Contato c = new Contato();
        System.out.print("Nome: ");
        c.setNome(scanner.nextLine());
        System.out.print("Telefone: ");
        c.setTelefone(Long.parseLong(scanner.nextLine()));
        agenda.adicionarContato(c);
        System.out.println("Contato salvo com sucesso!");
    }

    private static void listarTodos(ListaTelefonica agenda) throws SelectException {
        Map<Character, List<Contato>> mapa = agenda.listarContatos();
        if (mapa.isEmpty()) {
            System.out.println("\nA agenda está vazia.");
            return;
        }
        System.out.println("\n--- Todos os Contatos ---");
        for (Map.Entry<Character, List<Contato>> entrada : mapa.entrySet()) {
            System.out.println("\n[" + entrada.getKey() + "]");
            for (Contato c : entrada.getValue()) {
                System.out.println("  - " + c.toString());
            }
        }
    }

    private static void buscar(ListaTelefonica agenda, Scanner scanner) throws SelectException {
        System.out.print("\nDigite a letra inicial para buscar: ");
        char letra = scanner.nextLine().charAt(0);
        List<Contato> lista = agenda.buscarContatos(letra);
        if (lista.isEmpty()) {
            System.out.println("Nenhum contato encontrado com a letra '" + Character.toUpperCase(letra) + "'.");
        } else {
            System.out.println("\n--- Contatos com a letra '" + Character.toUpperCase(letra) + "' ---");
            for (Contato c : lista) {
                System.out.println("  - " + c.toString());
            }
        }
    }

    private static void remover(ListaTelefonica agenda, Scanner scanner) throws DeleteException {
        System.out.println("\n--- Remover Contato ---");
        System.out.print("Digite o nome exato do contato: ");
        String nome = scanner.nextLine();
        Contato c = new Contato();
        c.setNome(nome);
        agenda.removerContato(c);
        System.out.println("Contato removido com sucesso!");
    }

    private static void atualizar(ListaTelefonica agenda, Scanner scanner) throws UpdateException {
        System.out.println("\n--- Atualizar Contato ---");
        Contato c = new Contato();
        System.out.print("ID do contato: ");
        c.setId(Integer.parseInt(scanner.nextLine()));
        System.out.print("Novo nome: ");
        c.setNome(scanner.nextLine());
        System.out.print("Novo telefone: ");
        c.setTelefone(Long.parseLong(scanner.nextLine()));
        agenda.atualizarContato(c);
        System.out.println("Contato atualizado com sucesso!");
    }
}
