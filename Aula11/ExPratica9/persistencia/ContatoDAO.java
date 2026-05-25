package persistencia;

import dados.Contato;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ContatoDAO {
    private ArquivoContatoDAO arquivoContatoDAO = new ArquivoContatoDAO();

    public void insert(Contato contato) {
        List<Contato> contatos = arquivoContatoDAO.leContatos();
        contatos.add(contato);
        arquivoContatoDAO.salvaContatos(contatos);
    }

    public void delete(Contato contato) {
        List<Contato> contatos = arquivoContatoDAO.leContatos();
        contatos.remove(contato);
        arquivoContatoDAO.salvaContatos(contatos);
    }

    public Map<Character, List<Contato>> getAll() {
        List<Contato> contatos = arquivoContatoDAO.leContatos();
        
        Map<Character, List<Contato>> mapaContatos = new TreeMap<>();

        for (Contato c : contatos) {
            Character primeiraLetra = c.getNome().toUpperCase().charAt(0);

            if (!mapaContatos.containsKey(primeiraLetra)) {
                mapaContatos.put(primeiraLetra, new ArrayList<>());
            }

            mapaContatos.get(primeiraLetra).add(c);
        }

        return mapaContatos;
    }
}