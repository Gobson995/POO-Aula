package dados;

import java.util.ArrayList;
import java.util.List;

public class Viveiro {
    protected String noome; 
    protected float comprimento;
    protected float largura;

    protected List<Animal> animais = new ArrayList<>();

    public Viveiro() {
    }

    public String getNoome() {
        return noome;
    }
    public void setNoome(String noome) {
        this.noome = noome;
    }

    public float getComprimento() {
        return comprimento;
    }
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getLargura() {
        return largura;
    }
    public void setLargura(float largura) {
        this.largura = largura;
    }

    public List<Animal> getAnimais() {
        return animais;
    }
    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public float calculaEspaco() {
        return comprimento * largura;
    }

    private float espacoOcupado() {
        float ocupado = 0;
        for (Animal animal : animais) {
            ocupado += animal.calculaEspacoOcupado();
        }

        return ocupado;
    }

    public float espacoDisponivel() {
        return calculaEspaco() - espacoOcupado();
    }

    public boolean adicionarAnimal(Animal animal) {
        float espacoNecessario = animal.calculaEspacoOcupado() * 0.70f;
        if (espacoDisponivel() > espacoNecessario) {
            animais.add(animal);
            return true;
        }

        return false;
    }
}
