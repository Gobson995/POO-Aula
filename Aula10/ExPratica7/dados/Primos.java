package dados;

public class Primos extends Gerador {
    public void gerar (int quantidade) {
        int comeco = 2;
        while (quantidade > 0) {
            if (ehPrimo(comeco)) {
                sequencia.add(comeco);
                quantidade--;
            }
            comeco++; 
        }
    }

    public boolean ehPrimo (int n) {
        if (n < 2) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
