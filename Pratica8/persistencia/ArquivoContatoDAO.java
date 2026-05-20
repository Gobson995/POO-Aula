package persistencia;

import dados.Contato;
import java.util.ArrayList;
import java.util.List;

public class ArquivoContatoDAO {
    private final String caminho = "contatos.csv"; 
    
    private EditorTexto editorArquivo = new EditorTexto();

    private String toCSV(Contato c) {
        return c.getNome() + "," + c.getTelefone();
    }

    private Contato fromCSV(String s) {
        String[] atributos = s.split(",");

        Contato contato = new Contato();
        contato.setNome(atributos[0]);
        contato.setTelefone(atributos[1]); 

        return contato;
    }

    public List<Contato> leContatos() {
        List<Contato> contatos = new ArrayList<>();
        List<String> linhas = editorArquivo.leTexto(caminho);

        for (String linha : linhas) {
            
            if (!linha.trim().isEmpty()) { 
                contatos.add(fromCSV(linha));
            }
        }
        return contatos;
    }

    public void salvaContatos(List<Contato> contatos) {
        List<String> linhasCSV = new ArrayList<>();

        for (Contato c : contatos) {
            linhasCSV.add(toCSV(c));
        }
        
        editorArquivo.gravaTexto(caminho, linhasCSV);
    }
}