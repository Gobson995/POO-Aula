package dados;

public class Losango extends FormaGeometrica {
    
    public void setD(int valor) {
        this.medida1 = valor;
    }

    public void setd(int valor) {
        this.medida2 = valor;
    }

    @Override
    public int calculaArea() {
        return (medida1 * medida2) / 2;
    }

    @Override
    public int calculaPerimetro() {
        return (int) (4 * Math.sqrt(Math.pow(medida1, 2) / 4.0 + Math.pow(medida2, 2) / 4.0));
    }

    @Override
    public String toString() {
        return "Losango [D: " + medida1 + ", d: " + medida2 + 
               ", Área: " + calculaArea() + 
               ", Perímetro: " + calculaPerimetro() + "]";
    }
}