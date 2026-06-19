package pkg;

public class Mod implements IOperacaoInteira {
    @Override
    public int executar(int valor1, int valor2) {
        int dividendo = valor1;
        if (valor1 < 0) {
            dividendo = -valor1;
        }

        int divisor = valor2;
        if (valor2 < 0) {
            divisor = -valor2;
        }

        if (divisor == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida.");
        }

        while (dividendo >= divisor) {
            dividendo -= divisor;
        }

        if (valor1 < 0) {
            return -dividendo;
        } else {
            return dividendo;
        }
    }
}