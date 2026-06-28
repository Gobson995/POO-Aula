package dados;

public class Aquario extends Viveiro {
    private float altura;
    private float temperatura;

    public Aquario(String nome, float comprimento, float largura, float altura, float temperatura) {
        super(nome, comprimento, largura);
        this.altura = altura;
        this.temperatura = temperatura;
    }

    @Override
    public float calculaEspaco() {
        return this.altura * this.comprimento * this.largura;
    }

    @Override
    public boolean adicionarAnimal(Animal animal) {
        if (!(animal instanceof Peixe)) {
            return false;
        }

        Peixe p = (Peixe) animal;

        if (Math.abs(p.getTemperaturaIdeal() - this.temperatura) > 3) {
            return false;
        }

        return super.adicionarAnimal(animal);
    }
}
