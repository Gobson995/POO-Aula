public class Emprestimo {
    private String dataInicio;
    private String dataTermino;
    private Livro livroAlugado;
    private Leitor leitor;
    private boolean devolvido;

    public Emprestimo() {
    }

    public Emprestimo(String dataInicio, String dataTermino, Livro livroAlugado, Leitor leitor) {
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.livroAlugado = livroAlugado;
        this.leitor = leitor;
        this.devolvido = false; // inicia como não devolvido
    }

    public String getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }
    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Livro getLivroAlugado() {
        return livroAlugado;
    }
    public void setLivroAlugado(Livro livroAlugado) {
        this.livroAlugado = livroAlugado;
    }

    public Leitor getLeitor() {
        return leitor;
    }
    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public boolean isDevolvido() {
        return devolvido;
    }
    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public String toString() {
        String status = "";
    
        if (this.devolvido == true) {
            status = "Sim";
        } else {
            status = "Nao";
        }
        
        return "Emprestimo [Data de Inicio: " + this.dataInicio + 
               ", Data de Termino: " + this.dataTermino + 
               ", Devolvido: " + status + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Emprestimo outro = (Emprestimo) obj;
        return this.dataInicio.equals(outro.dataInicio) && 
               this.livroAlugado.equals(outro.livroAlugado) && 
               this.leitor.equals(outro.leitor);
    }

}
