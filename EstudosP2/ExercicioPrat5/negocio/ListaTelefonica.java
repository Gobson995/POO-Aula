package negocio;

import dados.Contato;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaTelefonica {
    private List<Contato> contatos = new ArrayList<>();

    public void adicionarContato (Contato contato) {
        contatos.add(contato);
    }

    public void removerContato (Contato contato) {
        contatos.remove(contato);
    }

    public List<Contato> buscarContatos(char letra) {
        List<Contato> filtrados = new ArrayList<>();

        for (Contato c : contatos) {
            char inicial = Character.toUpperCase(c.getNome().charAt(0));
            if (inicial == Character.toUpperCase(letra)) {
                filtrados.add(c);
            }
        }
        return filtrados;
    }

    public Map<Character, List<Contato>> buscarContatos() {
        Map<Character, List<Contato>> mapa = new HashMap<>();

        for (Contato c : contatos) {
            char inicial = Character.toUpperCase(c.getNome().charAt(0));

            if (!mapa.containsKey(inicial)) {
                mapa.put(inicial, new ArrayList<>());
            }

            mapa.get(inicial).add(c);
        }

        return mapa;
    }
}
