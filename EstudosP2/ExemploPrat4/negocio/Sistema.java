package negocio;

import dados.*;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<ContaBancaria> contasBancarias = new ArrayList<>();

    public void cadastrarConta(ContaBancaria conta) {
        contasBancarias.add(conta);
    }

    public void realizarSaque(ContaBancaria conta, float valor) {
        conta.sacar(valor);
    }

    public boolean realizarDeposito(ContaCorrente conta, float valor) {
        return conta.depositar(valor);
    }

    public boolean realizarDeposito(ContaSalario conta, float valor, int cnpj) {
        return conta.depositar(valor, cnpj);
    }

    public List<ContaBancaria> getContas() {
        return contasBancarias;
    }

    public int getQuantidadesContas() {
        return contasBancarias.size();
    }

    public List<ContaCorrente> getContasCorrentes() {
        List<ContaCorrente> correntes = new ArrayList<>();
        for (ContaBancaria c : contasBancarias) {
            if (c instanceof ContaCorrente) {
                correntes.add((ContaCorrente) c);
            }
        }
        return correntes;
    }

    public List<ContaSalario> getContasSalarios() {
        List<ContaSalario> salarios = new ArrayList<>();
        for (ContaBancaria c : contasBancarias) {
            if (c instanceof ContaSalario) {
                salarios.add((ContaSalario) c);
            }
        }
        return salarios;
    }

    public String obterExtrato(ContaBancaria conta) {
        return conta.gerarExtrato();
    }
}
