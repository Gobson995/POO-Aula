import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main1 {
	
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/contato";
		String username = "postgres";
		String senha = "udesc";

		try {
			Class.forName("org.postgresql.Driver");

			Connection conexao = DriverManager.getConnection(url, username, senha);
			
			PreparedStatement consulta = conexao.prepareStatement("select * from pessoa");
			
			PreparedStatement insert = conexao.prepareStatement("insert into pessoa values (?,?,?,?)");
			
			PreparedStatement seqPessoa =  conexao.prepareStatement("select nextval('id_pessoa')");
			
			ResultSet seq = seqPessoa.executeQuery();
			
			seq.next();
				
			int novoValorSeq = seq.getInt(1); 
			
			insert.setInt(1, novoValorSeq);
			insert.setString(2, "Antonio");
			insert.setString(3, "111.222.333.44");
			insert.setInt(4, 342432);
			
			insert.executeUpdate();
			
			ResultSet resultado = consulta.executeQuery();
			
			while(resultado.next()) {
				System.out.print(resultado.getInt("id")+", ");
				System.out.print(resultado.getString("nome")+", ");
				System.out.print(resultado.getString("cpf")+"\n");
			}
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
