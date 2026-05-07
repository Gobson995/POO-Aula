package dados;

public class Aquario extends Viveiro {
    private float altura;
    private float temperatura;

    public Aquario() {
    }

    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public float calculaEspaco() {
        return comprimento * altura * largura;
    }

    @Override
    public boolean adicionarAnimal(Animal animal) {
        if (animal instanceof Peixe) {
            Peixe peixe = (Peixe) animal;

            if (Math.abs(this.temperatura - peixe.getTemperaturaIdeal()) <= 3.0f) {
                return super.adicionarAnimal(animal);
            }
            
        }
        return false;
    }


}
