public class Leitor {
    private String nome;
    private String sobrenome;
    private Emprestimo[] historico = new Emprestimo[10];
    private int quantidadeEmprestimos = 0;

    public Leitor() {
    }

    public Leitor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Emprestimo[] getHistorico() {
        return historico;
    }

    public int getQuantidadeEmprestimos() {
        return quantidadeEmprestimos;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        if (this.quantidadeEmprestimos < 10) {
            this.historico[this.quantidadeEmprestimos] = emprestimo;
            this.quantidadeEmprestimos++;
        }
    }

    public String toString() {
        return "Leitor: " + this.nome + " " + this.sobrenome;
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Leitor outro = (Leitor) obj;
        return this.nome.equals(outro.nome) && this.sobrenome.equals(outro.sobrenome);
    }
}