package apresentacao;

import dados.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Gerador> geradores = new ArrayList<>();
        geradores.add(new Abundantes());
        geradores.add(new Fatoriais());
        geradores.add(new Fibonacci());
        geradores.add(new Naturais());
        geradores.add(new Perfeitos());
        geradores.add(new Primos());
        geradores.add(new Quadrados());

        for (Gerador g : geradores) {
            if (g instanceof Perfeitos) {
                g.gerar(4);
            }
            else {
                g.gerar(10);
            }
            System.out.println(g.getClass().getSimpleName() + ": " + g.getSequencia());
        }

        System.out.println("\nRESULTADOS (Quem possui o maior valor)");

        Gerador maiorSomatorio = geradores.get(0);
        Gerador maiorMediaArit = geradores.get(0);
        Gerador maiorMediaGeom = geradores.get(0);
        Gerador maiorVariancia = geradores.get(0);
        Gerador maiorDesvioPadrao = geradores.get(0);
        Gerador maiorAmplitude = geradores.get(0);

        for (Gerador g : geradores) {
            if (g.somatorio() > maiorSomatorio.somatorio()) maiorSomatorio = g;
            if (g.mediaAritmetica() > maiorMediaArit.mediaAritmetica()) maiorMediaArit = g;
            if (g.mediaGeometrica() > maiorMediaGeom.mediaGeometrica()) maiorMediaGeom = g;
            if (g.variancia() > maiorVariancia.variancia()) maiorVariancia = g;
            if (g.desvioPadrao() > maiorDesvioPadrao.desvioPadrao()) maiorDesvioPadrao = g;
            if (g.amplitude() > maiorAmplitude.amplitude()) maiorAmplitude = g;
        }

        System.out.println("1. Maior Somatório: " + maiorSomatorio.getClass().getSimpleName() + " (" + maiorSomatorio.somatorio() + ")");
        System.out.println("2. Maior Média Aritmética: " + maiorMediaArit.getClass().getSimpleName() + " (" + String.format("%.2f", maiorMediaArit.mediaAritmetica()) + ")");
        System.out.println("3. Maior Média Geométrica: " + maiorMediaGeom.getClass().getSimpleName() + " (" + String.format("%.2f", maiorMediaGeom.mediaGeometrica()) + ")");
        System.out.println("4. Maior Variância: " + maiorVariancia.getClass().getSimpleName() + " (" + String.format("%.2f", maiorVariancia.variancia()) + ")");
        System.out.println("5. Maior Desvio Padrão: " + maiorDesvioPadrao.getClass().getSimpleName() + " (" + String.format("%.2f", maiorDesvioPadrao.desvioPadrao()) + ")");
        System.out.println("6. Maior Amplitude: " + maiorAmplitude.getClass().getSimpleName() + " (" + maiorAmplitude.amplitude() + ")");
    }
}