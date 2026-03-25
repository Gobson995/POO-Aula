public class Livro {
    private String titulo;
    private int id;
    private int paginas;
    private String genero;
    private Secao secaoLocalizada;

    public Livro() {
    }

    public Livro(int id, String titulo, int paginas, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.paginas = paginas;
        this.genero = genero;
    }

    public String getTitulo() { 
        return titulo; 
    }
    public void setTitulo(String titulo) { 
        this.titulo = titulo; 
    }

    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }

    public int getPaginas() { 
        return paginas; 
    }
    public void setPaginas(int paginas) { 
        this.paginas = paginas; 
    }

    public String getGenero() { 
        return genero; 
    }
    public void setGenero(String genero) { 
        this.genero = genero; 
    }

    public Secao getSecaoLocalizada() { 
        return secaoLocalizada; 
    }
    public void setSecaoLocalizada(Secao secaoLocalizada) { 
        this.secaoLocalizada = secaoLocalizada; 
    }

    public String toString() {
        return "Livro -> " + this.titulo + "/" + this.id + "\nGenero = " + this.genero;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Livro outroLivro = (Livro) obj;
        return this.id == outroLivro.id;
    }
}
