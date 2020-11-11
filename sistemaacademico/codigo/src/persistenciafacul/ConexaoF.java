package persistenciafacul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoF {
	
	private String login = "root";
	private String senha = "";
	private String url = "jdbc:mysql://localhost/academico";
	
	public Connection conexao = null;
	
	//Conecta com o banco de dados
	public Connection criarConexao() throws InterruptedException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			this.conexao = DriverManager.getConnection(url,login,senha);
		}
		catch(SQLException ex)
		{
			System.out.println("Erro! Não conectou com o banco de dados");
		}
		return this.conexao;
	 
	}
	

}
