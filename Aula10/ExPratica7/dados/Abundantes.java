package dados;

public class Abundantes extends Gerador {
    public void gerar (int quantidade) {
        int comeco = 1;
        while (quantidade > 0) {
            if (ehAbundante(comeco)) {
                sequencia.add(comeco);
                quantidade--;
            }

            comeco++;
        }
    }

    public boolean ehAbundante (int n) {
        int soma = 0;
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) soma += i;
        }

        if (n < soma) return true;
        return false;
    }
}
