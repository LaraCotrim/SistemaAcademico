package daof;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelof.Alunof;
import modelof.Turma;
import persistenciafacul.ConexaoF;

public class DaoLogin extends ConexaoF{
	
	
	//VALIDA LOGIN
	public String loginUser(int login) throws SQLException, InterruptedException
	{
		ResultSet rs = null;
		String cargo;
		Connection conn = this.criarConexao();
		
		
		String select = "select * from aluno where idaluno='" + login + "';";
		
		PreparedStatement st = conn.prepareStatement(select);
		rs = st.executeQuery(select);
		if (rs.next()) {
			
			cargo = "ALUNO";
			return cargo;

		}
		else
		{
			String select2 = "select * from funcionario where idfunc='" + login + "';";
			
			PreparedStatement st2 = conn.prepareStatement(select2);
			rs = st.executeQuery(select2);
			if(rs.next())
			{
				cargo = rs.getString("cargo");
				return cargo;
			}
			return cargo = null;
		}
		
	}
	
	//VALIDA SENHA DO USUARIO
	public boolean validaSenha(int login, String senha) throws SQLException, InterruptedException
	{
		ResultSet rs = null;
		
		Connection conn = this.criarConexao();
		
		
		String select = "select * from aluno where idaluno='" + login + "'and senha = '"+senha+"'";
		
		PreparedStatement st = conn.prepareStatement(select);
		rs = st.executeQuery(select);
		if (rs.next()) {
			
			
			return true;

		}
		else
		{
			String select2 = "select * from funcionario where idfunc='" + login + "'and senhaf = '"+senha+"'";
			
			PreparedStatement st2 = conn.prepareStatement(select2);
			rs = st.executeQuery(select2);
			if(rs.next())
			{
				return true;
			}
			return false;
		}
		
	}
	
	//RETORNA OBJETO ALUNO 
	public Alunof dadosAluno(int login) throws SQLException, InterruptedException
	{
		ResultSet rs = null;
		String cargo;
		Connection conn = this.criarConexao();
		Alunof objalu = new Alunof();
		
		String select = "select * from aluno where idaluno='" + login + "';";
		
		PreparedStatement st = conn.prepareStatement(select);
		rs = st.executeQuery(select);
		if (rs.next()) {
			objalu.setIdaluno(rs.getInt("idaluno"));
			objalu.setNomealuno(rs.getString("nomealuno"));
			objalu.setDatanasc(rs.getString("datanasc"));
			objalu.setEmail(rs.getString("email"));
			objalu.setDatamat(rs.getString("datamat"));
			objalu.setCurso(rs.getString("curso"));
			return objalu;
		}
		else
		{
			return null;
		}
	}
	
	//RETORNA OBJETO TURMA DO ALUNO
		public ArrayList<Turma> dadosTurma(int login) throws SQLException, InterruptedException
		{
			ResultSet rs = null;
			String cargo;
			Connection conn = this.criarConexao();
			ArrayList<Turma> lista = new ArrayList<Turma>();
			
			String select = "select t.idturma ,a.nomealuno,d.nomed ,f.nomefunc, t.n1 ,t.n2 ,t.presenca from turma t, aluno a,disciplina d,funcionario f \r\n" + 
					"where t.idalunofk = a.idaluno and t.iddisfk = d.iddis and d.idprof = f.idfunc and t.idalunofk ='" + login + "';";
			
			PreparedStatement st = conn.prepareStatement(select);
			rs = st.executeQuery(select);
			while (rs.next()) {
				
				Turma objt = new Turma();
				objt.setIdturma(rs.getInt("idturma"));
				objt.setNomealuno(rs.getString("nomealuno"));
				objt.setNomedisc(rs.getString("nomed"));
				objt.setNomeprof(rs.getString("nomefunc"));
				objt.setN1(rs.getDouble("n1"));
				objt.setN2(rs.getDouble("n2"));
				objt.setPresenca(rs.getInt("presenca"));
				lista.add(objt);
				
			}
			
			return lista;
		}
		
		//RETORNA DADOS TURMA AO PROFESSOR
		public ArrayList<Turma> dadosTurmaP(int login) throws SQLException, InterruptedException
		{
			ResultSet rs = null;
			String cargo;
			Connection conn = this.criarConexao();
			ArrayList<Turma> lista = new ArrayList<Turma>();
			
			String select = "select t.idturma ,t.idalunofk ,a.nomealuno,d.nomed ,f.nomefunc, t.n1 ,t.n2 ,t.presenca from turma t, aluno a,disciplina d,funcionario f \r\n" + 
					"where t.idalunofk = a.idaluno and t.iddisfk = d.iddis and d.idprof = f.idfunc and f.idfunc ='" + login + "';";
			
			PreparedStatement st = conn.prepareStatement(select);
			rs = st.executeQuery(select);
			while (rs.next()) {
				
				Turma objt = new Turma();
				objt.setIdturma(rs.getInt("idturma"));
				objt.setIdalunofk(rs.getInt("idalunofk"));
				objt.setNomealuno(rs.getString("nomealuno"));
				objt.setNomedisc(rs.getString("nomed"));
				objt.setNomeprof(rs.getString("nomefunc"));
				objt.setN1(rs.getDouble("n1"));
				objt.setN2(rs.getDouble("n2"));
				objt.setPresenca(rs.getInt("presenca"));
				lista.add(objt);
				
			}
			
			return lista;
		}
		
		
		public boolean alteraNotas(int idaluno, double n1, double n2)
		{
			
			try(Connection conn = this.criarConexao())
			{
				PreparedStatement pstm;
				
                String update = "UPDATE TURMA SET n1=?, n2=?";
                update += " WHERE idalunofk = ?";
                
				pstm = conn.prepareStatement(update);
				pstm.setDouble(1, n1);
				pstm.setDouble(2, n2);
				pstm.setInt(3, idaluno);
				
				int x =pstm.executeUpdate();
				
				if(x==0)
				{
					return false;
				}
				else
				{
					return true;
				}

			} catch(Exception e) {
				return false;
				
			}
			
		}
		
		public boolean alteraPresenca(int idaluno, int presenca)
		{
			
			try(Connection conn = this.criarConexao())
			{
				PreparedStatement pstm;
				
                String update = "UPDATE TURMA SET presenca=?";
                update += " WHERE idalunofk = ?";
                
				pstm = conn.prepareStatement(update);
				pstm.setDouble(1, presenca);
				pstm.setDouble(2, idaluno);
				
				
				int x =pstm.executeUpdate();
				
				if(x==0)
				{
					return false;
				}
				else
				{
					return true;
				}

			} catch(Exception e) {
				return false;
				
			}
			
		}



}
