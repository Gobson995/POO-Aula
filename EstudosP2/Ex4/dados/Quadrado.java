package dados;

import exceptions.DimensaoInvalidaException;

public class Quadrado extends Quadrilatero{
    private float lado;

    public Quadrado (float lado) throws DimensaoInvalidaException {
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
        return lado * lado;
    }

    @Override
    public float calcularPerimetro() {
        return lado * 4;
    }
}
