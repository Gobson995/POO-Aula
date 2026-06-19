package pkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SistemaProcessos {
    private List<Processo> processos = new ArrayList<>();
    private List<Juiz> juizes = new ArrayList<>();

    public void cadastrarProcesso(Processo processo) {
        processos.add(processo);
    }

    public void cadastrarJuiz(Juiz juiz) {
        juizes.add(juiz);
    }

    public void distribuirProcessos() throws ProcessoSemJuizException {
        Random random = new Random();
        List<Juiz> juizesDisponiveis = new ArrayList<>(juizes);

        while (!processos.isEmpty()) {
            if (juizesDisponiveis.isEmpty()) {
                throw new ProcessoSemJuizException();
            }

            int index = random.nextInt(juizesDisponiveis.size());
            Juiz juizSorteado = juizesDisponiveis.get(index);
            Processo p = processos.get(0);

            try {
                juizSorteado.cadastrarProcesso(p);
                processos.remove(0);
            } catch (PilhaCheiaException e) {
                juizesDisponiveis.remove(juizSorteado);
            }
        }
    }
}