package dados;
import java.util.*;

public abstract class Gerador implements ISequencia {
    protected List<Integer> sequencia = new ArrayList<>();

    public List<Integer> getSequencia() {
        return sequencia;
    }

    public abstract void gerar (int quantidade);

    public int sortear() {
        Random r = new Random();

        return sequencia.get(r.nextInt(sequencia.size()));
    }

    public long somatorio() {
        long soma = 0;

        for (int i = 0; i < sequencia.size(); i++) {
            soma += sequencia.get(i);
        }

        return soma;
    }

    public double mediaAritmetica() {
        return (double) somatorio()/sequencia.size();
    }

    public double mediaGeometrica() {
        double produto = 1;

        for (int i = 0; i < sequencia.size(); i++) {
            produto *= sequencia.get(i);
        }

        return Math.pow(produto, 1.0/sequencia.size());
    }

    public double variancia() {
        if (sequencia.size() <= 1) return 0.0;
        
        double soma = 0.0;
        double media = mediaAritmetica();

        for (int i = 0; i < sequencia.size(); i++) {
            soma += Math.pow((sequencia.get(i) - media), 2.0);
        }

        return soma/(sequencia.size() - 1);
    }

    public double desvioPadrao() {
        return Math.sqrt(variancia());
    }

    public long amplitude() {
        long maior = sequencia.get(0);
        long menor = sequencia.get(0);

        for (int i = 0; i < sequencia.size(); i++) {
            if (sequencia.get(i) <= menor) menor = sequencia.get(i);

            if (sequencia.get(i) >= maior) maior = sequencia.get(i);
        }

        return maior - menor;
    }
}
