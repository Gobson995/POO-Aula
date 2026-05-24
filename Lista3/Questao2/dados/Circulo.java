package dados;

public class Circulo extends FormaGeometrica {
    
    public void setRaio(int valor) {
        this.medida1 = valor;
        this.medida2 = valor * 2;
    }

    @Override
    public int calculaArea() {
        return (int) (Math.PI * Math.pow(medida1, 2));
    }

    @Override
    public int calculaPerimetro() {
        return (int) (Math.PI * medida2);
    }

    @Override
    public String toString() {
        return "Círculo [Raio: " + medida1 + ", Diâmetro: " + medida2 + 
               ", Área: " + calculaArea() + 
               ", Perímetro: " + calculaPerimetro() + "]";
    }
}