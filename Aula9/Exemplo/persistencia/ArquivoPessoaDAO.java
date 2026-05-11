package persistencia;

import dados.*;
import java.util.*;

public class ArquivoPessoaDAO {
    private final String caminho = "//home/gustavo-bada/Repositorios/POO-Aula/Aula9/Exemplo/pessoas.csv";
    
    private EditorTexto editorArquivo = new EditorTexto();

    private String toCSV(Pessoa pessoa) {
        String p = "";

        p += pessoa.getNome() + ",";
        p += pessoa.getIdade() + ",";
        p += pessoa.getAltura() + ",";
        p += pessoa.getMassa();

        return p;
    }

    private Pessoa fromCSV (String linhaCSV) {
        String atributos[] = linhaCSV.split(",");

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(atributos[0]);
        pessoa.setIdade(Integer.parseInt(atributos[1]));
        pessoa.setAltura(Float.parseFloat(atributos[2]));
        pessoa.setMassa(Float.parseFloat(atributos[3]));

        return pessoa;
    }

    private List<String> listaPessoaToString(List<Pessoa> pessoas) {
        List<String> listaPessoas = new ArrayList<>();

        for (Pessoa p : pessoas) {
            listaPessoas.add(toCSV(p));
        }
        return listaPessoas;
    }

    private List<Pessoa> stringToListaPessoa (List<String> listaPessoas) {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        for (String s : listaPessoas) {
            pessoas.add(fromCSV(s));
        }

        return pessoas;
    }

    public List<Pessoa> lePessoasArquivo() {
        return stringToListaPessoa(editorArquivo.leTexto(caminho));
    }

    public void salvaPessoaArquivo(Pessoa pessoa) {
        editorArquivo.gravaTexto(caminho, toCSV(pessoa));
    }

    public void salvaPessoasArquivo(List<Pessoa> pessoas) {
        editorArquivo.gravaTexto(caminho, listaPessoaToString(pessoas));
    }

}
