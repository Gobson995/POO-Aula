package apresentacao;

import dados.*;
import negocio.ReservaPassagem;

import java.util.Scanner;

public class Principal {
    private static ReservaPassagem sistema = new ReservaPassagem();
    private static Scanner sc = new Scanner(System.in);

    public static void main (String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            menu();

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    fazerReserva();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    cadastrarCidade();
                    break;
                case 4:
                    mostrarReserva();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opçao invalida!");
            }
        }
    }

    public static void menu() {
        System.out.println("1 - Fazer Reserva");
        System.out.println("2 - Cadastrar Cliente");
        System.out.println("3 - Cadastrar Cidade");
        System.out.println("4 - Mostrar Reserva");
        System.out.println("0 - Sair\n\n");
        System.out.println("Escolha uma opção: ");
    }
    

    public static void cadastrarCidade() {
        System.out.println("\nCadastrar Cidade");
        Cidade cidade = new Cidade();

        System.out.println("Nome da Cidade: ");
        cidade.setNome(sc.nextLine());

        System.out.println("Nome do Estado: ");
        cidade.setEstado(sc.nextLine());

        sistema.cadastrarCidade(cidade);
        System.out.println("Cidade Cadastrada com Sucesso");
    }

    public static void cadastrarCliente() {
        System.out.println("\nCadastrar Cliente");
        Cliente cliente = new Cliente();


        System.out.println("Digite seu Nome: ");
        cliente.setNome(sc.nextLine());

        System.out.println("Digite seu CPF: ");
        cliente.setCpf(sc.nextLine());

        System.out.println("Digite seu endereço: ");
        cliente.setEndereco(sc.nextLine());

        System.out.println("Digite seu telefone: ");
        cliente.setTelefone(sc.nextLine());

        sistema.cadastrarCliente(cliente);
        System.out.println("Cliente Cadastrado com Sucesso");
    }

    public static void fazerReserva() {
         System.out.println("\nFazer Reserva");

        System.out.println("\nDigite o CPF do cliente");
        String cpf = sc.nextLine();

        Cliente clienteSelecionado = null;

        for (Cliente c : sistema.mostrarClientes()) {
            if (c.getCpf().equals(cpf)) {
                clienteSelecionado = c;
                break;
            }
        }

        if (clienteSelecionado == null) {
            System.out.println("Não tem nenhum cliente cadastrado com esse CPF");
            return;
        }

        Cidade[] cidades = sistema.mostrarCidades();

        if (cidades.length < 2) {
            System.out.println("Tem menos de duas cidades cadastradas, não da para viajar");
            return;
        }

        System.out.println("\n\nCidades Disponiveis: ");
        for (int i = 0; i < cidades.length; i++) {
            System.out.println("[" + i + "]" + cidades[i]);
        }

        System.out.println("Escolha a cidade de ORIGEM: ");
        int indiceOrigem = sc.nextInt();

        System.out.println("Escolha a cidade de DESTINO: ");
        int indiceDestino = sc.nextInt();
        sc.nextLine();

        if (indiceDestino == indiceOrigem) {
            System.out.println("Não pode ter uma passagem de uma cidade para ela mesma");
            return;
        }

        Cidade origem = cidades[indiceOrigem];
        Cidade destino = cidades[indiceDestino];

        Reserva ida = new Reserva();
        ida.setOrigem(origem);
        ida.setDestino(destino);

        System.out.print("Numero da Reserva (Ida): ");
        ida.setNumReserva(sc.nextInt());
        sc.nextLine();
        
        System.out.print("Data do Voo (Ida): ");
        ida.setDataVoo(sc.nextLine());
        
        System.out.print("Hora do Voo (Ida): ");
        ida.setHoraVoo(sc.nextLine());
        
        System.out.print("Classe do Voo: ");
        ida.setClasseVoo(sc.nextLine());
        
        System.out.print("Numero da Poltrona: ");
        ida.setPoltrona(sc.nextInt());
        sc.nextLine();
        
        System.out.print("Preco da passagem: R$");
        ida.setPreco(Float.parseFloat(sc.nextLine()));

        System.out.print("A passagem e de ida e volta? (S/N): ");
        String resposta = sc.nextLine();
        
        if (resposta.equalsIgnoreCase("S")) {
            Reserva volta = new Reserva();
            volta.setOrigem(destino);
            volta.setDestino(origem);
            
            System.out.print("Numero da Reserva (Volta): ");
            volta.setNumReserva(sc.nextInt());
            sc.nextLine();
            
            System.out.print("Data do Voo (Volta): ");
            volta.setDataVoo(sc.nextLine());
            
            System.out.print("Hora do Voo (Volta): ");
            volta.setHoraVoo(sc.nextLine());
            
            volta.setClasseVoo(ida.getClasseVoo());
            volta.setPreco(ida.getPreco());
            
            System.out.print("Numero da Poltrona (Volta): ");
            volta.setPoltrona(sc.nextInt());
            sc.nextLine();
        
            sistema.reservarVolta(clienteSelecionado, ida, volta);
            System.out.println("\nPassagens de Ida e Volta reservadas com sucesso!");    
        } 
        else {
            ida.setIdaEVolta(false);
            sistema.reservarIda(clienteSelecionado, ida);
            System.out.println("\nPassagem de Ida reservada com sucesso!");
        }
    }

    public static void mostrarReserva() {
        System.out.println("\nMostrar Reservas");
        System.out.print("Digite o CPF do Cliente: ");
        String cpf = sc.nextLine();

        Reserva[] reservas = sistema.mostrarReservas(cpf);

        if (reservas != null && reservas.length > 0) {
            for (Reserva r : reservas) {
                System.out.println(r);
                System.out.println("\n\n");
            }
        }
        else {
            System.out.println("Não foi encontrado nenhuma reserva nesse CPF");
        }
    }
}
