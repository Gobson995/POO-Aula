package pkg;

public class Multiplicacao extends Soma {
    @Override
    public int executar(int valor1, int valor2) {
        int resultado = 0;
        
        int v1 = valor1;
        if (valor1 < 0) {
            v1 = -valor1;
        }
        
        int v2 = valor2;
        if (valor2 < 0) {
            v2 = -valor2;
        }

        for (int i = 0; i < v2; i++) {
            resultado = super.executar(resultado, v1);
        }

        boolean ehNegativo = (valor1 < 0 && valor2 >= 0) || (valor1 >= 0 && valor2 < 0);
        
        if (ehNegativo) {
            return -resultado;
        } else {
            return resultado;
        }
    }
}