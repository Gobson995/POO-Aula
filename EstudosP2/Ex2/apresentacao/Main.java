package apresentacao;

import dados.*;
import negocio.*;
import exceptions.*;

public class Main {
    public static void main (String[] args) {
        Aluguel meuAluguel = new Aluguel();

        Carro c1 = new Carro("ABC-1234", "Fiat Uno", 100.0f, 4);
        Moto m1 = new Moto("XYZ-9876", "Honda CG", 50.0f, 150);
        Carro c2 = new Carro("QWE-5555", "Jeep Compass", 300.0f, 4);

        c2.setDisponivel(false);

        try {
            meuAluguel.adicionarVeiculo(c1);
            System.out.println(c1.getModelo() + " adicionado com sucesso.");

            meuAluguel.adicionarVeiculo(m1);
            System.out.println(m1.getModelo() + " adicionado com sucesso.");

            meuAluguel.adicionarVeiculo(c2); 
            System.out.println(c2.getModelo() + " adicionado com sucesso.");
        } catch (VeiculoIndisponivelException e) {
            System.out.println(e);
        }
    }
}
