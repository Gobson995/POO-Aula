package dados;

public class ContaCorrente extends ContaBancaria {
    public ContaCorrente() {
        super();
    }

    public boolean depositar(float valor) {
        this.saldo += valor;
        return true;
    }

    @Override
    public String gerarExtrato() {
        return "Conta Corrente:\nCPF:" + this.getCpf() + "\n" +
                super.gerarExtrato();
    }

    @Override
    public String toString () {
        return "Conta Corrente:\n" + super.toString();
    }
}
