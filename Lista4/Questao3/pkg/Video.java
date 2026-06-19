package pkg;

public class Video extends Arquivo {
    private Qualidade qualidade;

    public Video(String nome, Qualidade qualidade) throws NomeInvalidoException {
        super(nome);
        this.qualidade = qualidade;
        setExtensao(".mp4");
    }

    @Override
    public String toString() {
        String qualidadeStr = qualidade.name().replace("Q", "");
        return getNome() + getExtensao() + "\n  Qualidade: " + qualidadeStr;
    }
}