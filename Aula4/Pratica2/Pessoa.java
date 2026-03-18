package Aula4.Pratica2;

public class Pessoa {
    private String nome;
    private int idade;
    private double altura;
    private double massa;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setIdade (int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public double getMassa() {
        return this.massa;
    }

    public double calculaIMC() {
        return this.massa / (this.altura * this.altura);
    }
}
