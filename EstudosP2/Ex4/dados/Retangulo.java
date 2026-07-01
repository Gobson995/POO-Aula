package dados;

import exceptions.DimensaoInvalidaException;

public class Retangulo extends Quadrilatero {
    private float base;
    private float altura;

    public Retangulo (float base, float altura) throws DimensaoInvalidaException {
        if (base <= 0 || altura <= 0) {
            throw new DimensaoInvalidaException();
        }

        this.base = base;
        this.altura = altura;
    }

    public float getBase() {
        return base;
    }
    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }

    @Override
    public float calcularArea() {
        return base * altura;
    }

    @Override
    public float calcularPerimetro() {
        return 2 * (base + altura);
    }
}
