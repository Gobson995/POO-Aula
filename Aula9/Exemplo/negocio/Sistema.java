package negocio;

import persistencia.*;
import dados.*;

import java.util.*;

public class Sistema {
    private PessoaDAO pessoaDAO = new PessoaDAO();
    
    public void adicionarPessoa(Pessoa p) {
        pessoaDAO.insert(p);;
    }

    public void removerPessoa(Pessoa p) {
        pessoaDAO.delete(p);;
    }

    public List<Pessoa> getList() {
        return pessoaDAO.getAll();
    }
}
