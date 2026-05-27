package persistencia;

import dados.Contato;
import exceptions.*;

import java.util.*;
import java.io.*;

public class ContatoDAO {
    private ArquivoContatoDAO arquivoContatoDAO = new ArquivoContatoDAO();

    public void insert(Contato contato) throws ContatoJaCadastradoException, ErroNaLeituraException, ErroNaEscritaException{
        List<Contato> contatos = arquivoContatoDAO.leContatos();
        
        if (contatos.contains(contato)) {
            ContatoJaCadastradoException cj = new ContatoJaCadastradoException("Contato ja cadastrado");
            throw cj;
        }

        if (contatos == null) {
            contatos = new ArrayList<>();
        }
        contatos.add(contato);

        arquivoContatoDAO.salvaContatos(contatos);
    }

    public void delete(Contato contato) throws ContatoNaoCadastradoException, ErroNaLeituraException, ErroNaEscritaException{
        List<Contato> contatos = arquivoContatoDAO.leContatos();
        
        if (!contatos.contains(contato)) {
            ContatoNaoCadastradoException cn = new ContatoNaoCadastradoException("O contato ainda nao foi cadastrado");
            throw cn;
        }

        contatos.remove(contato);
        arquivoContatoDAO.salvaContatos(contatos);
    }

    public Map<Character, List<Contato>> getAll() throws ErroNaLeituraException{
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