package pkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<IOperacaoInteira> operacoes = new ArrayList<>();
        operacoes.add(new Soma());
        operacoes.add(new Multiplicacao());
        operacoes.add(new MDC());
        operacoes.add(new Mod());

        Random random = new Random();

        for (IOperacaoInteira operacao : operacoes) {
            int valor1 = random.nextInt(50) + 1; 
            int valor2 = random.nextInt(20) + 1;

            String nomeOperacao = operacao.getClass().getSimpleName();
            int resultado = operacao.executar(valor1, valor2);

            System.out.println("Operação: " + nomeOperacao);
            System.out.println("Valor 1: " + valor1 + " | Valor 2: " + valor2);
            System.out.println("Resultado: " + resultado + "\n\n");
        }    
    }
}