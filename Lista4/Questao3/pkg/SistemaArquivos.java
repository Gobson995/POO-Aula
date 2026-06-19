package pkg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaArquivos {
    private Map<String, List<Arquivo>> diretorios = new HashMap<>();

    private void adicionarArquivo(String diretorio, Arquivo arquivo) {
        if (!diretorios.containsKey(diretorio)) {
            diretorios.put(diretorio, new ArrayList<>());
        }
        diretorios.get(diretorio).add(arquivo);
    }

    public void criarDocumento(String nome, String diretorio, String texto) throws NomeInvalidoException {
        Documento doc = new Documento(nome, texto);
        adicionarArquivo(diretorio, doc);
    }

    public void criarMusica(String nome, String diretorio, int duracao) throws NomeInvalidoException {
        Musica musica = new Musica(nome, duracao);
        adicionarArquivo(diretorio, musica);
    }

    public void criarVideo(String nome, String diretorio, Qualidade qualidade) throws NomeInvalidoException {
        Video video = new Video(nome, qualidade);
        adicionarArquivo(diretorio, video);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String diretorio : diretorios.keySet()) {
            sb.append(diretorio).append(":\n");
            for (Arquivo arquivo : diretorios.get(diretorio)) {
                sb.append("  ").append(arquivo.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}