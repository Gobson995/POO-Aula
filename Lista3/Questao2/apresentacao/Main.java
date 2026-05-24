package apresentacao;

import dados.Circulo;
import dados.Losango;
import dados.TrianguloEquilatero;

public class Main {
    public static void main(String[] args) {
        TrianguloEquilatero t1 = new TrianguloEquilatero();
        t1.setLado(5);
        TrianguloEquilatero t2 = new TrianguloEquilatero();
        t2.setLado(10);

        Losango l1 = new Losango();
        l1.setD(8);
        l1.setd(6);
        Losango l2 = new Losango();
        l2.setD(10);
        l2.setd(4);

        Circulo c1 = new Circulo();
        c1.setRaio(4);
        Circulo c2 = new Circulo();
        c2.setRaio(7);

        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}
