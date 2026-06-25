package negocio;

import dados.Contato;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import persistencia.Conexao;
import persistencia.ContatoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ListaTelefonica {
    private ContatoDAO contatoDAO;

    public ListaTelefonica(String senha) throws ClassNotFoundException, SQLException, SelectException {
        Conexao.setSenha(senha);
        contatoDAO = ContatoDAO.getInstance();
    }

    public void adicionarContato(Contato contato) throws InsertException, SelectException {
        contatoDAO.insert(contato);
    }

    public void removerContato(Contato contato) throws DeleteException {
        contatoDAO.delete(contato);
    }

    public void atualizarContato(Contato contato) throws UpdateException {
        contatoDAO.update(contato);
    }

    public Map<Character, List<Contato>> listarContatos() throws SelectException {
        List<Contato> contatos = contatoDAO.selectAll();
        Map<Character, List<Contato>> mapa = new TreeMap<>();
        for (Contato c : contatos) {
            Character primeiraLetra = c.getNome().toUpperCase().charAt(0);
            if (!mapa.containsKey(primeiraLetra)) {
                mapa.put(primeiraLetra, new ArrayList<>());
            }
            mapa.get(primeiraLetra).add(c);
        }
        return mapa;
    }

    public List<Contato> buscarContatos(char letra) throws SelectException {
        Map<Character, List<Contato>> todos = listarContatos();
        char letraMaiuscula = Character.toUpperCase(letra);
        if (todos.containsKey(letraMaiuscula)) {
            return todos.get(letraMaiuscula);
        }
        return new ArrayList<>();
    }
}
