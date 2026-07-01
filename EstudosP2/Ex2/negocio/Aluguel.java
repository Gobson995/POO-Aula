package negocio;

import java.util.*;
import dados.*;
import exceptions.*;

public class Aluguel {
    private List<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo v) throws VeiculoIndisponivelException {
        if (!v.isDisponivel()) {
            throw new  VeiculoIndisponivelException();
        }

        veiculos.add(v);
        v.setDisponivel(false);
    }

    public float fecharAluguel(int dias) {
        float somaTotal = 0;

        for (Veiculo v : veiculos) {
            somaTotal += v.calcularCustoTotal(dias);

            if (v instanceof ISeguravel) {
                ISeguravel seguravel = (ISeguravel) v;

                somaTotal += seguravel.calcularValorSeguro();
            }
        }

        return somaTotal;
    }
}
