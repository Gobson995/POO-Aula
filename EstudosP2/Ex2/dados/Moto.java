package dados;

public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String placa, String modelo, float valorDiaria, int cilindradas) {
        super(placa, modelo, valorDiaria);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }
    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public float calcularCustoTotal(int dias) {
        return (getValorDiaria() * dias);
    }

    @Override
    public String toString() {
        return "Moto [cilindradas=" + cilindradas + ", getPlaca()=" + getPlaca() + ", getModelo()=" + getModelo()
                + ", getValorDiaria()=" + getValorDiaria() + "]";
    }

    

}
