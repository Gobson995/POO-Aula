package dados;

public class Viveiro {
    protected String nome;
    protected float comprimento;
    protected float largura;

    protected Animal[] animais = new Animal[50];
    protected int quantAnimais = 0;

    public Viveiro(String nome, float comprimento, float largura) {
        this.nome = nome;
        this.comprimento = comprimento;
        this.largura = largura;
    }
    
    public float calculaEspaco() {
        return this.comprimento * this.largura;
    }

    public float espacoOcupado() {
        float ocupado = 0;

        for (int i = 0; i < quantAnimais; i++) {
            ocupado += animais[i].calculaEspacoOcupado();
        }
        return ocupado;
    }

    public float espacoDisponivel() {
        return calculaEspaco() - espacoOcupado();
    }

    public boolean adicionarAnimal(Animal animal) {
        if (espacoDisponivel() > (animal.calculaEspacoOcupado() * 0.7f)) {
            if (quantAnimais < animais.length) {
                animais[quantAnimais] = animal;
                quantAnimais++;
                return true;
            }
        }
        return false;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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

    public Animal[] getAnimais() {
        return animais;
    }

    public int getQuantAnimais() {
        return quantAnimais;
    }    
}
