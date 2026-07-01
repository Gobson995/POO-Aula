package dados;

import exceptions.DimensaoInvalidaException;

public class Circulo extends FormaGeometrica {
    private float raio;

    public Circulo (float raio) throws DimensaoInvalidaException {
        if (raio <= 0) {
            throw new DimensaoInvalidaException();
        }

        this.raio = raio;
    }

    public float getRaio() {
        return raio;
    }
    public void setRaio(float raio) {
        this.raio = raio;
    }

    @Override
    public float calcularArea() {
        return (float) (Math.PI * Math.pow(raio,2));
    }

    @Override
    public float calcularPerimetro() {
        return (float) (2 * Math.PI * raio);
    }
}
