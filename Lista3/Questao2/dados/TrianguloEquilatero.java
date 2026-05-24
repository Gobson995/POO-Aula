package dados;

public class TrianguloEquilatero extends FormaGeometrica {
    
    public void setLado(int valor) {
        this.medida1 = valor;
    }

    @Override
    public int calculaArea() {
        return (int) ((Math.sqrt(3) / 4.0) * Math.pow(medida1, 2));
    }

    @Override
    public int calculaPerimetro() {
        return 3 * medida1;
    }

    @Override
    public String toString() {
        return "Triângulo Equilátero [Lado: " + medida1 + 
               ", Área: " + calculaArea() + 
               ", Perímetro: " + calculaPerimetro() + "]";
    }
}