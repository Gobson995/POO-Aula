package negocio;

import dados.FormaGeometrica;
import exceptions.ColecaoVaziaException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorFormasGeometricas {
    private List<FormaGeometrica> formas = new ArrayList<>();

    public void inserir(FormaGeometrica f) {
        formas.add(f);
    }

    public float calcularSomaAreas() {
        float somaTotal = 0;
        for (FormaGeometrica f : formas) {
            somaTotal += f.calcularArea();
        }

        return somaTotal;
    }

    public FormaGeometrica obterMaiorArea() throws ColecaoVaziaException {
        if (formas.isEmpty()) {
            throw new ColecaoVaziaException();
        }

        FormaGeometrica maior = formas.get(0);

        for(FormaGeometrica f : formas) {
            if (f.compararArea(maior) > 0) {
                maior = f;
            }
        }

        return maior;
    }
}
