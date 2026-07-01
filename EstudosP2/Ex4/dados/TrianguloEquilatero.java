package dados;

import exceptions.DimensaoInvalidaException;

public class TrianguloEquilatero extends FormaGeometrica{
    private float lado;

    public TrianguloEquilatero (float lado) throws DimensaoInvalidaException {
        if (lado <= 0) {
            throw new DimensaoInvalidaException();
        }

        this.lado = lado;
    }

    public float getLado() {
        return lado;
    }
    public void setLado(float lado) {
        this.lado = lado;
    }

    @Override
    public float calcularArea() {
        return (float) ((Math.pow(lado, 2) * Math.sqrt(3)) / 4);
    }

    @Override
    public float calcularPerimetro() {
        return 3 * lado;
    }
}
