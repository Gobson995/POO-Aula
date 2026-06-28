package dados;

public class ContaBancaria {
    private int cpf;
    protected float saldo;

    public ContaBancaria() {
        this.saldo = 0;
    }

    public float sacar(float valor) {
        this.saldo -= valor;
        return valor;
    }

    public String gerarExtrato() {
        return "Saldo disponivel: R$" + this.saldo;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "ContaBancaria [cpf=" + cpf + "]";
    }
}
