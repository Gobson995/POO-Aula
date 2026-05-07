package dados;

public class Peixe extends Animal{
    private float temperaturaIdeal;

    private Peixe() {
    }

    public float getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    public void setTemperaturaIdeal(float temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }

    @Override
    public float calculaEspacoOcupado() {
        return altura * largura * comprimento;
    }
}
