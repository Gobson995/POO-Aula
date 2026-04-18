public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private String cpf;
    private String cidade;
    private int idade;

    public Pessoa() {
    }

    public Pessoa (String nome, int idade, String cpf, String cidade) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return nome + ", " + idade + ", " + cpf + ", " + cidade;
    }


    @Override
    public int compareTo(Pessoa outra) {
        return this.nome.compareToIgnoreCase(outra.getNome());
    }


}
