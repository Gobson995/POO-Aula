package apresentacao;

import java.sql.SQLException;
import java.util.List;
import dados.Endereco;
import dados.Pessoa;
import exceptions.*;
import persistencia.Conexao;
import persistencia.PessoaDAO;
import negocio.Sistema;

public class Principal {
	
	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		
		Pessoa p = new Pessoa();
		p.setNome("Ana");
		p.setCpf("999.444.333.00");
		p.setTelefone(454812);
		
		try {
			sistema.cadastraPessoa(p);
			
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}
}
