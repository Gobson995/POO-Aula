package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import dados.Endereco;
import dados.Pessoa;
import exceptions.*;
import java.util.List;
import java.util.ArrayList;

public class PessoaDAO {
	
	private static PessoaDAO instance = null;
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement select;
	private PreparedStatement selectAll;
	private PreparedStatement newId;
	
	EnderecoDAO enderecoDAO;
	
	private PessoaDAO () throws SQLException, ClassNotFoundException {
		
		Connection conexao = Conexao.getConexao();
		
		insert = conexao.prepareStatement("insert into pessoa values (?,?,?,?)");
		delete = conexao.prepareStatement("delete form pessoa where id = ?");
		update = conexao.prepareStatement("update pessoa set nome = ?, cpf = ?, telefone = ? where id = ?");
		select = conexao.prepareStatement("select * from pessoa where id = ?");
		selectAll = conexao.prepareStatement("select * from pessoa");
		newId = conexao.prepareStatement("select nextval('id_pessoa')");
		
		enderecoDAO = EnderecoDAO.getInstance();
	}

	public static PessoaDAO getInstance() throws SQLException, ClassNotFoundException {
		if(instance == null) {
			instance = new PessoaDAO();
		}
		return instance;
	}
	
	public int newId() throws SelectException {
		try {
			ResultSet rs = newId.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return 0;
			}
		} catch (SQLException e) {
			throw new SelectException("Não foi possível gerar um novo id.");
		}
	}

	public void delete(Pessoa p) throws DeleteException {
		
		try {
			if(p.getEndereco() != null) {
				enderecoDAO.deleteEnderecoPessoa(p.getEndereco());
			}
			delete.setInt(1, p.getId());
			delete.executeUpdate();
		} catch (Exception e) {
			throw new DeleteException("N�o foi poss�vel excluir a pessoa.");
		}
	}
	
	
	
	public void insert(Pessoa pessoa)  {
		try {
			pessoa.setId(newId());
			insert.setInt(1,pessoa.getId());
			insert.setString(2, pessoa.getNome());
			insert.setString(3, pessoa.getCpf());
			insert.setInt(4, pessoa.getTelefone());
			insert.executeUpdate();
			
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}
	}
	
	public Pessoa select(int idPessoa)  {
		Pessoa pessoa = null;
		
		try {
			select.setInt(1, idPessoa);
			ResultSet rs = select.executeQuery();
			if(rs.next()) {
				pessoa = new Pessoa();
				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setTelefone(rs.getInt("telefone"));
				
				Endereco endereco = enderecoDAO.selectEnderecoPessoa(pessoa.getId());
				if (endereco != null)
					pessoa.setEndereco(endereco);
			}
			
			
		} catch (SQLException e) {
			System.err.print(e.getMessage());
		}
		
		return pessoa;
	}
		
	public List<Pessoa> selectAll() {

		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		Pessoa pessoa = null;
		
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()) {
				pessoa = new Pessoa();
				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setTelefone(rs.getInt("telefone"));
				// Implementar a sele��o do endere�o
				Endereco endereco = enderecoDAO.selectEnderecoPessoa(pessoa.getId());
				pessoa.setEndereco(endereco);
				
				pessoas.add(pessoa);
			}
		
			
		} catch (SQLException e) {
			System.err.print(e.getMessage());
		}
		return pessoas;
	}
	
	public void update(Pessoa pessoa) {
		
		try {
			update.setString(1, pessoa.getNome());
			update.setString(2, pessoa.getCpf());
			update.setInt(3, pessoa.getTelefone());
			update.setInt(4, pessoa.getId());
			update.executeUpdate();
			// Implementar a atualiza��o do endere�o
			
			if(pessoa.getEndereco() != null)
				pessoa.getEndereco().setIdPessoa(pessoa.getId());
				enderecoDAO.updateEnderecoPessoa(pessoa.getEndereco());
			
			
		} catch (SQLException e) {
			System.err.print(e.getMessage());
		}
		
		
	}

}
