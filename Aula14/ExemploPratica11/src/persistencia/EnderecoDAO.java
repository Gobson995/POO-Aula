package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Endereco;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class EnderecoDAO {
	
	private static EnderecoDAO instance = null;
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement deleteByIdPessoa;
	private PreparedStatement update;
	private PreparedStatement updateByIdPessoa; 
	private PreparedStatement select;
	private PreparedStatement selectAll;
	private PreparedStatement selectByIdPessoa;
	private PreparedStatement newId;
	
	
	private EnderecoDAO () throws SQLException, ClassNotFoundException {
		
		Connection conexao = Conexao.getConexao();
		
		insert = conexao.prepareStatement("insert into endereco values (?,?,?,?,?)");
		delete = conexao.prepareStatement("delete form endereco where id = ?");
		deleteByIdPessoa = conexao.prepareStatement("delete form endereco where id_pessoa = ?");
		update = conexao.prepareStatement("update endereco set rua = ?, numero = ?, cidade = ? where id = ?");
		updateByIdPessoa = conexao.prepareStatement("update endereco set rua = ?, numero = ?, cidade = ? where id_pessoa = ?");
		select = conexao.prepareStatement("select * from endereco where id = ?");
		selectAll = conexao.prepareStatement("select * from endereco");
		selectByIdPessoa = conexao.prepareStatement("select * from endereco where id_pessoa = ?");
		newId = conexao.prepareStatement("select nextval('id_endereco')");
		
	}
	
	public static EnderecoDAO getInstance() throws SQLException, ClassNotFoundException {
		if(instance == null) {
			instance = new EnderecoDAO();
		}
		return instance;
	}

	
	public int newId()  {
		ResultSet rs;
		int resultado = 0;
		try {
			rs = newId.executeQuery();
			if(rs.next()) {
				resultado =  rs.getInt(1);
			}
			else {
				resultado = 0;
			}
		} catch (SQLException e) {
			System.err.print(e.getMessage());
		}
		return resultado;
	}
	
	
	public void insert(Endereco endereco)  {
		try {
			endereco.setId(newId());
			insert.setInt(1,endereco.getId());
			insert.setString(2, endereco.getRua());
			insert.setInt(3, endereco.getNumero());
			insert.setString(4, endereco.getCidade());
			insert.setInt(5, endereco.getIdPessoa());
			insert.executeUpdate();
						
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}
	}
		
	public void delete(Endereco endereco)  {
		
		try {
			delete.setInt(1, endereco.getId());
			delete.executeUpdate();
		} catch (Exception e) {
			System.err.print(e.getMessage()); 			
		}
	}

	public void deleteEnderecoPessoa(Endereco endereco) {
		
		try {
			deleteByIdPessoa.setInt(1, endereco.getIdPessoa());
			deleteByIdPessoa.executeUpdate();
		} catch (Exception e) {
			System.err.print(e.getMessage()); 			
		}
	}
	
	
	public void update(Endereco endereco)  {
		
		try {
			updateByIdPessoa.setString(1, endereco.getRua());
			updateByIdPessoa.setInt(2, endereco.getNumero());
			updateByIdPessoa.setString(3, endereco.getCidade());
			updateByIdPessoa.setInt(4, endereco.getId());
			updateByIdPessoa.executeUpdate();
		} catch (Exception e) {
			System.err.print(e.getMessage()); 			
		}
	}

	public void updateEnderecoPessoa(Endereco endereco) {
		
		try {
			updateByIdPessoa.setString(1, endereco.getRua());
			updateByIdPessoa.setInt(2, endereco.getNumero());
			updateByIdPessoa.setString(3, endereco.getCidade());
			updateByIdPessoa.setInt(4, endereco.getIdPessoa());
			updateByIdPessoa.executeUpdate();
		} catch (Exception e) {
			System.err.print(e.getMessage()); 			
		}
	}
	

	public Endereco select(int idEndereco)  {
		ResultSet rs;
		Endereco endereco = null;
		
		try {
			select.setInt(1, idEndereco);
			rs = select.executeQuery();
			if(rs.next()) {
				endereco = new Endereco();
				endereco.setId(rs.getInt("id"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setIdPessoa(rs.getInt("id_pessoa"));
			}
			
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}
		return endereco;
	}
	

	public List<Endereco> selectAll()  {
		ResultSet rs;
		Endereco endereco = null;
		List<Endereco> enderecos = new ArrayList<Endereco>();
		
		try {
			rs = selectAll.executeQuery();
			while(rs.next()) {
				endereco = new Endereco();
				endereco.setId(rs.getInt("id"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setIdPessoa(rs.getInt("id_pessoa"));
				enderecos.add(endereco);
			}
			
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}
		return enderecos;
	}
	
	
		public Endereco selectEnderecoPessoa(int idPessoa)  {
		ResultSet rs;
		Endereco endereco = null;
		
		try {
			selectByIdPessoa.setInt(1, idPessoa);
			rs = selectByIdPessoa.executeQuery();
			if(rs.next()) {
				endereco = new Endereco();
				endereco.setId(rs.getInt("id"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setIdPessoa(rs.getInt("id_pessoa"));
			}
			
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}
		return endereco;
	}
	
}
