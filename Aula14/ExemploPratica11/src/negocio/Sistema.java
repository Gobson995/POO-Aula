package negocio;

import persistencia.PessoaDAO;
import java.sql.SQLException;
import dados.Pessoa;
import exceptions.*;
import java.util.List;

public class Sistema {
		
	
	public void cadastraPessoa(Pessoa pessoa) throws SQLException, ClassNotFoundException {
		PessoaDAO pessoaDAO = PessoaDAO.getInstance();
		pessoaDAO.insert(pessoa);
	}
	
	
	public void atualizaPessoa(Pessoa pessoa) throws SQLException, ClassNotFoundException {
		PessoaDAO pessoaDAO = PessoaDAO.getInstance();
		pessoaDAO.update(pessoa);
	}
	
	
	public List<Pessoa> getPessoas() throws SQLException, ClassNotFoundException {
		PessoaDAO pessoaDAO = PessoaDAO.getInstance();
		return pessoaDAO.selectAll();
	}
}
