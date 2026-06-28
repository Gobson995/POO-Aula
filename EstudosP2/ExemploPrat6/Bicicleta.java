public class Bicicleta extends Veiculo {
    private int numeroMarchas;

    public int getNumeroMarchas() {
        return numeroMarchas;
    }
    public void setNumeroMarchas(int numeroMarchas) {
        this.numeroMarchas = numeroMarchas;
    }

    @Override
    public String info() {
        return "\nBicicleta\n" + 
               "Cor: " + this.getCor().getCor() + "\n" + 
               "Número de marchas: " + this.numeroMarchas + "\n";
    }
}
