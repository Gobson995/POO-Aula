package negocio;

import dados.*;
import java.util.ArrayList;
import java.util.List;

public class Zoologico {
    private List<Animal> animais = new ArrayList<>();
    private List<Viveiro> viveiros = new ArrayList<>();

    public void cadastrarViveiro(Viveiro viveiro) {
        viveiros.add(viveiro);
    }

    public void cadastrarAnimal(Animal animal) {
        animais.add(animal);
    }

    public boolean alocarAnimal(Animal animal, Viveiro viveiro) {
        return viveiro.adicionarAnimal(animal);
    }

    public List<Aquario> getSoAquarios() {
        List<Aquario> aquarios = new ArrayList<>();
        for (Viveiro v : viveiros) {
            if (v instanceof Aquario) {
                aquarios.add((Aquario) v);
            }
        }
        return aquarios;
    }

    public List<Viveiro> getSoViveiros() {
        List<Viveiro> soViveiros = new ArrayList<>();
        for (Viveiro v : viveiros) {
            if (!(v instanceof Aquario)) {
                soViveiros.add((Viveiro) v);
            }
        }
        return soViveiros;
    }
}
