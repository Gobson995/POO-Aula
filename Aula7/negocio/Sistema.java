package negocio;

import dados.*;
import java.util.*;

public class Sistema {
    private List<ContaBancaria> contasBancarias = new ArrayList<>();
    private int quantidade = 0;

    public void cadastrarConta(ContaBancaria conta) {
        contasBancarias.add(conta);
        quantidade++;
    }

    public void realizarSaque(ContaBancaria conta, float valor) {
        conta.sacar(valor);
    }

    public boolean realizarDeposito(ContaCorrente conta, float valor) {
        return conta.depositar(valor);
    }

    public boolean realizarDeposito(ContaSalario conta, float valor, String cnpj) {
        return conta.depositar(valor, cnpj);
    }

    public ContaBancaria[] getContas() {
        return contasBancarias.toArray(new ContaBancaria[0]);
    }

    public ContaCorrente[] getContasCorrentes() {
        List<ContaCorrente> correntes = new ArrayList<>();
        for (ContaBancaria c : contasBancarias) {
            if (c instanceof ContaCorrente) {
                correntes.add((ContaCorrente) c);
            }
        }
        return correntes.toArray(new ContaCorrente[0]);
    }

    public ContaSalario[] getContasSalario() {
        List<ContaSalario> salarios = new ArrayList<>();
        for (ContaBancaria c : contasBancarias) {
            if (c instanceof ContaSalario) {
                salarios.add((ContaSalario) c);
            }
        }
        return salarios.toArray(new ContaSalario[0]);
    }

    public String obterExtrato(ContaBancaria conta) {
        return conta.gerarExtrato();
    }

}
