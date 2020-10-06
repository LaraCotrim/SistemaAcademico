package persistenciafacul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoF {
	
	public static Connection criarConexao() {
		String url = "jdbc:mysql://localhost:3306/faculdade?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String pass = "newrootpassword";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			return conn;
		} catch (SQLException e) {
			System.err.println("Erro ao conectar");
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			System.err.println("Classe do driver não encontrada");
			e.printStackTrace();
			return null;
		}
	}
	

	  public static void main(String [] args) throws SQLException, ClassNotFoundException { 
		  
	  
	  ConexaoF conexao = new ConexaoF();
	  
	  Connection conn = ConexaoF.criarConexao();
	  
	  System.out.println(conn);
	  
	  }
	 
	

}
