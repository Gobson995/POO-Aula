public class Carro extends Veiculo {
    private int numeroPortas;
    private Combustivel combustivel;

    public int getNumeroPortas() {
        return numeroPortas;
    }
    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }
    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public String info() {
        return "\nCarro\n" + "Cor: " + this.getCor() + "\nNumero de portas: " +
               this.numeroPortas + "\nTipo de combustivel: " + combustivel  + "\n";
    }



    
}
