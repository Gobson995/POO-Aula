package dados;

public class Perfeitos extends Gerador {
    public void gerar (int quantidade) {
        int comeco = 1;
        while (quantidade > 0) {
            if (ehPerfeito(comeco)) {
                sequencia.add(comeco);
                quantidade--;
            }

            comeco++;
        }            
    }

    public boolean ehPerfeito (int n) {
        int soma = 0;
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) soma += i;
        }

        if (soma == n) return true;
        return false;
    }
}
