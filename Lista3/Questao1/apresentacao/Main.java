package apresentacao;

import dados.*;

public class Main {
    public static void main(String[] args) {
        Cachorro cachorro1 = new Cachorro("JaTeDisse");
        Cachorro cachorro2 = new Cachorro("Aurora");

        Gato gato1 = new Gato("Mingau");
        Gato gato2 = new Gato("Tom");

        Vaca vaca1 = new Vaca("Mimosa");
        Vaca vaca2 = new Vaca("Malhada");

        System.out.println(cachorro1.emitirSom());
        System.out.println(cachorro2.emitirSom());
        System.out.println(gato1.emitirSom());
        System.out.println(gato2.emitirSom());
        System.out.println(vaca1.emitirSom());
        System.out.println(vaca2.emitirSom());
    }
}