package Aula4.Pratica2;

public class Grupo {
    private Pessoa[] grupo = new Pessoa[5];
    private int numeroPessoas= 0;

    public Grupo () {   
    }

    public void setPessoa(Pessoa p) {
        if (this.numeroPessoas < 5) {
            this.grupo[this.numeroPessoas] = p;
            this.numeroPessoas++;
        }
    }

    public Pessoa[] getPessoas() {
        return this.grupo;
    }

    public void ordena() {
        for (int i = 0; i < this.numeroPessoas; i++) {
            for (int j = i + 1; j < this.numeroPessoas; j++) {
                if (this.grupo[j].calculaIMC() >  this.grupo[i].calculaIMC()) {
                    Pessoa aux = this.grupo[j];
                    this.grupo[j] = this.grupo[i];
                    this.grupo[i] = aux;
                }
            }
        }
    }
}
