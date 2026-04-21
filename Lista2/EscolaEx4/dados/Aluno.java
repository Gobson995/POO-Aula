package dados;

public class Aluno {
    private String nome;
    private int idade;
    private double[] notas = new double[5];
    
    public Aluno() {
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double[] getNotas() {
        return notas;
    }
    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }

        return soma / 5.0;
    }

    @Override
    public String toString() {
        return nome + " (Média: " + String.format("%.1f", calcularMedia()) + ")";
    }
}
