package apresentacao;

import dados.*;
import negocio.*;
import java.util.*;

public class Main {
    private static Sistema sistema = new Sistema();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main (String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("1. Cadastrar Conta Corrente");
            System.out.println("2. Cadastrar Conta Salário");
            System.out.println("3. Realizar Depósito");
            System.out.println("4. Realizar Saque");
            System.out.println("5. Ver Extrato");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: cadastrarCorrente(); break;
                case 2: cadastrarSalario(); break;
                case 3: depositar(); break;
                case 4: sacar(); break;
                case 5: verExtrato(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarCorrente() {
        ContaCorrente cc = new ContaCorrente();
        System.out.print("CPF do titular: ");
        cc.setCpf(scanner.nextLine());
        cc.setSaldo(0);
        sistema.cadastrarConta(cc);
        System.out.println("Conta Corrente cadastrada!");
    }

    private static void cadastrarSalario() {
        ContaSalario cs = new ContaSalario();
        System.out.print("CPF do titular: ");
        cs.setCpf(scanner.nextLine());
        System.out.print("CNPJ da Empresa pagadora: ");
        cs.setCnpjEmpresa(scanner.nextLine());
        cs.setSaldo(0);
        sistema.cadastrarConta(cs);
        System.out.println("Conta Salário cadastrada!");
    }

    private static void depositar() {
        System.out.print("Digite o CPF da conta: ");
        String cpf = scanner.nextLine();
        ContaBancaria conta = buscarPorCpf(cpf);

        if (conta != null) {
            System.out.print("Valor do depósito: ");
            float valor = scanner.nextFloat();
            scanner.nextLine();

            if (conta instanceof ContaCorrente) {
                sistema.realizarDeposito((ContaCorrente) conta, valor);
                System.out.println("Depósito realizado!");
            } else if (conta instanceof ContaSalario) {
                System.out.print("Digite o CNPJ da empresa depositante: ");
                String cnpj = scanner.nextLine();
                if (sistema.realizarDeposito((ContaSalario) conta, valor, cnpj)) {
                    System.out.println("Depósito autorizado pela empresa!");
                } else {
                    System.out.println("ERRO: CNPJ não autorizado para esta conta salário.");
                }
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void sacar() {
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        ContaBancaria conta = buscarPorCpf(cpf);

        if (conta != null) {
            System.out.print("Valor do saque: ");
            float valor = scanner.nextFloat();
            scanner.nextLine();
            sistema.realizarSaque(conta, valor);
            System.out.println("Operação de saque processada. Saldo atual: R$" + conta.getSaldo());
        }
        else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void verExtrato() {
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        ContaBancaria conta = buscarPorCpf(cpf);
        if (conta != null) {
            System.out.println(sistema.obterExtrato(conta));
        }
    }

    private static ContaBancaria buscarPorCpf(String cpf) {
        for (ContaBancaria c : sistema.getContas()) {
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }
}
