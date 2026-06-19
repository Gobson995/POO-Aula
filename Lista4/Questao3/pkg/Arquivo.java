package pkg;

public abstract class Arquivo {
    private String nome;
    private String extensao;

    public Arquivo(String nome) throws NomeInvalidoException {
        if (nome.contains("\n")) {
            throw new NomeInvalidoException("O nome nao pode possuir quebras de linha.");
        }
        if (nome.contains("[") || nome.contains("]") || nome.contains("(") || nome.contains(")")) {
            throw new NomeInvalidoException("O nome nao pode possuir colchetes ou parenteses.");
        }
        if (nome.contains("'") || nome.contains("\"")) {
            throw new NomeInvalidoException("O nome nao pode possuir aspas simples ou duplas.");
        }
        if (nome.length() < 10 || nome.length() > 256) {
            throw new NomeInvalidoException("O nome deve possuir entre 10 e 256 caracteres.");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    @Override
    public abstract String toString();
}