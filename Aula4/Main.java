package Aula4;

public class Main {
    public static void main (String[] args) {
        Carro carro1 = new Carro();

        carro1.nome = "Uno";
        carro1.ano = 2002;
        carro1.numeroPortas = 2;
        carro1.cor = "Verde";

        carro1.apresentar();
    }
}
