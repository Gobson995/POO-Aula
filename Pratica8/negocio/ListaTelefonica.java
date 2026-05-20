package negocio;

import dados.Contato;
import persistencia.ContatoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListaTelefonica {
    private ContatoDAO contatoDAO;

    public ListaTelefonica() {
        this.contatoDAO = new ContatoDAO();
    }

    public void adicionarContato(Contato contato) {
        contatoDAO.insert(contato);
    }

    public void removerContato(Contato contato) {
        contatoDAO.delete(contato);
    }

    public Map<Character, List<Contato>> listarContatos() {
        return contatoDAO.getAll();
    }

    public List<Contato> buscarContatos(char letra) {
        Map<Character, List<Contato>> todosContatos = contatoDAO.getAll();
        char letraMaiuscula = Character.toUpperCase(letra);
        
        if (todosContatos.containsKey(letraMaiuscula)) {
            return todosContatos.get(letraMaiuscula);
        } else {
            return new ArrayList<>();
        }
    }
}