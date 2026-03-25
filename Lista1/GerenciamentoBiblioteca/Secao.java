public class Secao {
    private String categoria;
    private int corredor;
    private Bibliotecario responsavel;
    private Livro[] acervo = new Livro[100];
    private int quantidadeLivros = 0;

    public Secao() {
    }

    public Secao(String categoria, int corredor) {
        this.corredor = corredor;
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCorredor() {
        return corredor;
    }
    public void setCorredor(int corredor) {
        this.corredor = corredor;
    }

    public Bibliotecario getResponsavel() {
        return responsavel;
    }
    public void setResponsavel(Bibliotecario responsavel) {
        this.responsavel = responsavel;
    }

    public Livro[] getAcervo() {
        return acervo;
    }

    public int getQuantidadeLivros() {
        return quantidadeLivros;
    }
    
    public void adicionarLivro(Livro livro) {
        if (this.quantidadeLivros < 100) {
            this.acervo[this.quantidadeLivros] = livro;
            this.quantidadeLivros++;
        }
    }

    public String toString() {
        String info = "Secao: " + this.categoria + " (Corredor " + this.corredor + ")\n";
        if (this.responsavel != null) {
            info += "Responsavel: " + this.responsavel.getNome();
        }
        return info;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Secao outra = (Secao) obj;
        return this.categoria.equals(outra.categoria) && this.corredor == outra.corredor;
    }
}