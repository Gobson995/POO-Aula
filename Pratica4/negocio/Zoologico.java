package negocio;

import dados.*;
import java.util.*;

public class Zoologico {
    private List<Animal> animais = new ArrayList<>();
    private List<Viveiro> viveiros = new ArrayList<>();

    public void cadastrarViveiro(Viveiro viveiro) {
        viveiros.add(viveiro);
    }

    public void cadastrarAnimais(Animal animal) {
        animais.add(animal);
    }

    public boolean alocarAnimal(Animal animal, Viveiro viveiro) {
        return viveiro.adicionarAnimal(animal);
    }
    
    public Aquario[] getSoAquarios() {
        List<Aquario> listaAquarios = new ArrayList<>();
        for (Viveiro v : viveiros) {
            if (v instanceof Aquario) {
                listaAquarios.add((Aquario) v);
            }
        }
        return listaAquarios.toArray(new Aquario[0]);
    }

    public Viveiro[] getSoViveiros() {
        List<Viveiro> listaViveiros = new ArrayList<>();
        for (Viveiro v : viveiros) {
            if (!(v instanceof Aquario)) {
                listaViveiros.add(v);
            }
        }
        return listaViveiros.toArray(new Viveiro[0]);
    }
}
