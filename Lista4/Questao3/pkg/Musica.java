package pkg;

public class Musica extends Arquivo {
    private int duracao;

    public Musica(String nome, int duracao) throws NomeInvalidoException {
        super(nome);
        this.duracao = duracao;
        setExtensao(".mp3");
    }

    @Override
    public String toString() {
        return getNome() + getExtensao() + "\n  Duracao: " + duracao;
    }
}