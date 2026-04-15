package dados;

public class ContaCorrente extends ContaBancaria {
    public boolean depositar(float valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }
}
