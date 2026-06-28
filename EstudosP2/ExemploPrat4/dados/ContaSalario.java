package dados;

public class ContaSalario extends ContaBancaria {
    private int cnpjEmpresa;

    public ContaSalario() {
        super();
    }

    public boolean depositar(float valor, int cnpj) {
        if (cnpj == this.cnpjEmpresa) {
            this.saldo += valor;
            return true;
        }
        return false;
    }

    @Override
    public String gerarExtrato() {
        return "Conta Salario:\nCNPJ da Empresa:" + this.cnpjEmpresa + "\n" +
                super.gerarExtrato();
    }

    public int getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(int cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    @Override
    public String toString () {
        return "Conta Salario:\n" + super.toString() + "\nCNPJ: " + this.cnpjEmpresa;
    }

    

}