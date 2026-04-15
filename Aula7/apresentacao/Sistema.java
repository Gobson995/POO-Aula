package apresentacao;

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

    public ContaBancaria[] getContas() {
        return contasBancarias.toArray(new ContaBancaria[0]);
    }

    public ContaCorrente[] getContasCorrentes() {
        List<ContaCorrente>
    }

}
