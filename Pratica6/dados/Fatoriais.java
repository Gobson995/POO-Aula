package dados;

public class Fatoriais extends Gerador{
    public void gerar(int quantidade) {
        for (int i = 1; i <= quantidade; i++) {
            sequencia.add(calculaFatorial(i));
        }
    }

    public int calculaFatorial(int n) {
        int fatorial = 1;
        for (int i = 2; i <= n; i++) {
            fatorial *= i;
        }

        return fatorial;
    }
}
