package pkg;

public class MDC implements IOperacaoInteira {
    @Override
    public int executar(int valor1, int valor2) {
        int a = valor1;
        if (valor1 < 0) {
            a = -valor1;
        }

        int b = valor2;
        if (valor2 < 0) {
            b = -valor2;
        }

        if (a == 0) {
            return b;
        }
        
        if (b == 0) {
            return a;
        }

        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        
        return a;
    }
}