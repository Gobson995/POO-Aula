public class Bibliotecario {
    private String nome;
    private String sobrenome;
    private Secao secaoResponsavel;
    private float salario;
    
    public Bibliotecario() {
    }

    public Bibliotecario(String nome, String sobrenome, float salario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.salario = salario;
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

    public Secao getSecaoResponsavel() {
        return secaoResponsavel;
    }
    public void setSecaoResponsavel(Secao secaoResponsavel) {
        this.secaoResponsavel = secaoResponsavel;
    }

    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String toString() {
        return "Bibliotecario: " + this.nome + " " + this.sobrenome + " - Salario: R$" + this.salario;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Bibliotecario outro = (Bibliotecario) obj;
        return this.nome.equals(outro.nome) && this.sobrenome.equals(outro.sobrenome);
    }

}
