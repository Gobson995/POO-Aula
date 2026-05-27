package apresentacao;

import dados.Contato;
import negocio.ListaTelefonica;
import exceptions.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaTelefonica agenda = new ListaTelefonica();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n========== AGENDA TELEFÔNICA ==========");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Listar Todos os Contatos");
            System.out.println("3 - Buscar Contato por Letra");
            System.out.println("4 - Remover Contato");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    try {
                        adicionar(agenda, scanner);
                    }
                    catch(ContatoJaCadastradoException cj) {
                        System.err.println(cj.getMessage());  
                    }
                    catch(ErroNaLeituraException al) {
                        System.err.println(al.getMessage());  
                    }
                    catch(ErroNaEscritaException eg) {
                        System.err.println(eg.getMessage());  
                    }
                    break;
                case 2:
                    try{
                        listarTodos(agenda);
                    }
                    catch(ErroNaLeituraException al) {
                        System.err.println(al.getMessage());  
                    }
                    break;
                case 3:
                    try {
                        buscar(agenda, scanner);
                    }
                    catch(ErroNaLeituraException al) {
                        System.err.println(al.getMessage());  
                    }
                    break;
                case 4:
                    try {
                        remover(agenda, scanner);
                    }
                    catch(ContatoNaoCadastradoException cn) {
                        System.err.println(cn.getMessage());
                    }
                    catch(ContatoJaCadastradoException cj) {
                        System.err.println(cj.getMessage());  
                    }
                    catch(ErroNaLeituraException al) {
                        System.err.println(al.getMessage());  
                    }
                    catch(ErroNaEscritaException eg) {
                        System.err.println(eg.getMessage());  
                    }
                    break;
                case 5:
                    System.out.println("Saindo do sistema... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void adicionar(ListaTelefonica agenda, Scanner scanner) throws ContatoJaCadastradoException, ErroNaLeituraException, ErroNaEscritaException {
        System.out.println("\n--- Novo Contato ---");
        Contato c = new Contato();

        System.out.print("Nome: ");
        c.setNome(scanner.nextLine());

        System.out.print("Telefone: ");
        c.setTelefone(scanner.nextLine());

        agenda.adicionarContato(c);
        System.out.println("Contato salvo no arquivo com sucesso!");
    }

    private static void listarTodos(ListaTelefonica agenda) throws ErroNaLeituraException {
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

    private static void buscar(ListaTelefonica agenda, Scanner scanner) throws ErroNaLeituraException{
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

    private static void remover(ListaTelefonica agenda, Scanner scanner) throws ContatoJaCadastradoException, ErroNaLeituraException, ErroNaEscritaException, ContatoNaoCadastradoException {
        System.out.println("\n--- Remover Contato ---");
        System.out.print("Digite o NOME EXATO do contato que deseja remover: ");
        String nome = scanner.nextLine();

        Contato contatoTemp = new Contato();
        contatoTemp.setNome(nome);

        agenda.removerContato(contatoTemp);
        System.out.println("Comando de remoção enviado! (Se o nome existia, foi apagado).");
    }
}