package apresentacao;

import dados.*;
import negocio.ReservaPassagem;
import java.util.Scanner;

public class Main {

    private static ReservaPassagem gerenciador = new ReservaPassagem();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n=== SISTEMA DE RESERVAS DE VOO ===");
            System.out.println("1. Cadastrar Cidade");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Fazer Reserva");
            System.out.println("4. Mostrar Reservas de um Cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opcao: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarCidade();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    fazerReserva();
                    break;
                case 4:
                    mostrarReservas();
                    break;
                case 5:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        }
    }

    public static void cadastrarCidade() {
        System.out.println("\n-- CADASTRAR CIDADE --");
        Cidade novaCidade = new Cidade();
        
        System.out.print("Nome da Cidade: ");
        novaCidade.setNome(scanner.nextLine());
        
        System.out.print("Estado (Sigla): ");
        novaCidade.setEstado(scanner.nextLine());
        
        gerenciador.cadastrarCidade(novaCidade);
        System.out.println("Cidade cadastrada com sucesso!");
    }

    public static void cadastrarCliente() {
        System.out.println("\n-- CADASTRAR CLIENTE --");
        Cliente novoCliente = new Cliente();
        
        System.out.print("CPF (Apenas numeros): ");
        novoCliente.setCpf(scanner.nextLine());
        
        System.out.print("Nome Completo: ");
        novoCliente.setNome(scanner.nextLine());
        
        System.out.print("Endereco: ");
        novoCliente.setEndereco(scanner.nextLine());
        
        System.out.print("Telefone: ");
        novoCliente.setTelefone(scanner.nextLine());
        
        gerenciador.cadastrarCliente(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public static void fazerReserva() {
        System.out.println("\n-- FAZER RESERVA --");
        System.out.print("Digite o CPF do Cliente: ");
        String cpf = scanner.nextLine();
        
        Cliente clienteEncontrado = null;
        for (int i = 0; i < gerenciador.getQuantClientes(); i++) {
            if (gerenciador.mostrarClientes()[i].getCpf().equals(cpf)) {
                clienteEncontrado = gerenciador.mostrarClientes()[i];
                break;
            }
        }
        
        if (clienteEncontrado == null) {
            System.out.println("Erro: Cliente nao encontrado.");
            return; 
        }

        System.out.println("\nCidades Disponiveis para Voo:");
        for (int i = 0; i < gerenciador.getQuantCidades(); i++) {
            System.out.println("[" + i + "] " + gerenciador.mostrarCidades()[i].getNome());
        }

        System.out.print("Numero da cidade de ORIGEM: ");
        int indiceOrigem = scanner.nextInt();
        System.out.print("Numero da cidade de DESTINO: ");
        int indiceDestino = scanner.nextInt();
        scanner.nextLine(); 

        Reserva reservaIda = new Reserva();
        
        reservaIda.setOrigem(gerenciador.mostrarCidades()[indiceOrigem]);
        reservaIda.setDestino(gerenciador.mostrarCidades()[indiceDestino]);
        
        System.out.print("Numero do Voo: ");
        reservaIda.setNumReserva(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Data (DD/MM/AAAA): ");
        reservaIda.setDataVoo(scanner.nextLine());
        System.out.print("Hora: ");
        reservaIda.setHoraVoo(scanner.nextLine());
        System.out.print("Preco: ");
        reservaIda.setPreco(scanner.nextFloat());
        scanner.nextLine();
        System.out.print("Classe: ");
        reservaIda.setClasseVoo(scanner.nextLine());
        System.out.print("Poltrona: ");
        reservaIda.setPoltrona(scanner.nextInt());
        scanner.nextLine();

        System.out.print("A passagem e de IDA e VOLTA? (S/N): ");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("S")) {
            Reserva reservaVolta = new Reserva();

            reservaVolta.setOrigem(gerenciador.mostrarCidades()[indiceDestino]);
            reservaVolta.setDestino(gerenciador.mostrarCidades()[indiceOrigem]);
            
            System.out.println("\n--- DADOS DA VOLTA ---");
            System.out.print("Numero do Voo de Volta: ");
            reservaVolta.setNumReserva(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Data da Volta: ");
            reservaVolta.setDataVoo(scanner.nextLine());
            System.out.print("Hora da Volta: ");
            reservaVolta.setHoraVoo(scanner.nextLine());
            System.out.print("Preco da Volta: ");
            reservaVolta.setPreco(scanner.nextFloat());
            scanner.nextLine();
            System.out.print("Classe da Volta: ");
            reservaVolta.setClasseVoo(scanner.nextLine());
            System.out.print("Poltrona da Volta: ");
            reservaVolta.setPoltrona(scanner.nextInt());
            scanner.nextLine();

            gerenciador.reservarVolta(clienteEncontrado, reservaIda, reservaVolta);
            System.out.println("\nPassagem de Ida e Volta comprada com sucesso!");

        } else {
            gerenciador.reservarIda(clienteEncontrado, reservaIda);
            System.out.println("\nPassagem de Ida comprada com sucesso!");
        }
    }

    public static void mostrarReservas() {
        System.out.println("\n-- BUSCAR RESERVAS DO CLIENTE --");
        System.out.print("Digite o CPF do Cliente: ");
        String cpf = scanner.nextLine();
        
        Reserva[] historico = gerenciador.mostrarReservas(cpf);
        
        if (historico == null) {
            System.out.println("Cliente nao encontrado.");
        } else {
            System.out.println("\n=== HISTORICO DE VOOS ===");
            boolean temReserva = false;
            
            for (int i = 0; i < historico.length; i++) {
                if (historico[i] != null) {
                    System.out.println(historico[i].toString());
                    System.out.println("---------------------------------");
                    temReserva = true;
                }
            }
            if (!temReserva) {
                System.out.println("Este cliente ainda nao comprou passagens.");
            }
        }
    }
}