package dados;

public class Carro extends Veiculo implements ISeguravel {
    private int quantidadePortas;

    public Carro(String placa, String modelo, float valorDiaria, int quantidadePortas) {
        super(placa, modelo, valorDiaria);
        this.quantidadePortas = quantidadePortas;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }
    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public float calcularCustoTotal(int dias) {
        return ((getValorDiaria() * dias) + 50.0f);
    }

    @Override
    public float calcularValorSeguro() {
        return 100.0f;
    }

    @Override
    public String toString() {
        return "Carro [quantidadePortas=" + quantidadePortas + ", getPlaca()=" + getPlaca() + ", getModelo()="
                + getModelo() + ", getValorDiaria()=" + getValorDiaria() + "]";
    }
}
