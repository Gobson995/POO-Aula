package negocio;

import dados.Contato;
import java.util.*;

public class ListaTelefonica {
    private Map<Character, List<Contato>> contatos;

    // criar ela no construtor
    public ListaTelefonica() {
        contatos = new HashMap<>();

        for (char chave = 'A'; chave <= 'Z'; chave++) {
            contatos.put(chave, new LinkedList<>());
        }

    }

    public void adicionarContato(Contato contato) {
        String nome = contato.getNome();

        if (nome != null && !nome.isEmpty()) {
            char primeiraLetra = nome.toUpperCase().charAt(0);
            List<Contato> lista = contatos.get(primeiraLetra);
            if (lista != null) {
                lista.add(contato);
            }
        }
    }

    public void removerContato(Contato contato) {
        String nome = contato.getNome();

        if (nome != null && !nome.isEmpty()) {
            char primeiraLetra = nome.toUpperCase().charAt(0);
            List<Contato> lista = contatos.get(primeiraLetra);
            if (lista != null) {
                lista.remove(contato);
            }
        }
    }

    public List<Contato> buscarContatos (char letra) {
        letra = Character.toUpperCase(letra);

        if (letra >= 'A' && letra <= 'Z') {
            return contatos.get(letra);
        }
        return null; 
    }

    public Map<Character, List<Contato>> buscarContatos() {
        return contatos;
    }


}
