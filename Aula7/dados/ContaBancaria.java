package dados;

public class ContaBancaria {
    protected String cpf;
    protected float saldo;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float sacar(float valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return saldo;
        }
        return -1;
    }

    public String gerarExtrato() {
        return "O saldo atual eh: " + saldo;
    }
}
