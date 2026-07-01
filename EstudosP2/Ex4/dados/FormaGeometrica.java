package dados;

public abstract class FormaGeometrica implements Comparavel {
    public abstract float calcularArea();
    public abstract float calcularPerimetro();

    @Override
    public int compararArea(FormaGeometrica outra) {
        float minhaArea = this.calcularArea();
        float areaDaOutra = outra.calcularArea();

        if (minhaArea > areaDaOutra) return 1;
        else if (minhaArea < areaDaOutra) return -1;
        else return 0;
    }
}
