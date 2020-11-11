package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import daof.DaoLogin;
import modelof.Alunof;
import modelof.Turma;

public class VisaoLogin {
	
	
	
	public static void professor(int login) throws SQLException, InterruptedException
	{
		Scanner sc = new Scanner(System.in);
		
		DaoLogin daologin = new DaoLogin();
		
		int opcao;
		
		System.out.println("+=====================================+");
		System.out.println("| SISTEMA ACADEMICO                   |");
		System.out.println("| OPÇÕES:                             |");
		System.out.println("| 1 - MINHAS TURMAS:                  |");
		System.out.println("| 2 - SAIR:                           |");
		opcao = sc.nextInt();
		
		while(opcao<2)
		{
			if(opcao == 1)
			{
				
				ArrayList<Turma> lista = daologin.dadosTurmaP(login);
				System.out.println("+--------+------+-----------------------+-------------+-------------------+--------+--------+------------+");
				System.out.println("|ID TURMA|  ID  | NOME                  |  DISCIPLINA |  PROFESSOR        |   N1   |   N2   | PRESENCA   |");
				System.out.println("+--------+------+-----------------------+-------------+-------------------+--------+--------+------------+");
				for (Turma turma : lista) {
					System.out.printf("| %6d |%6d| %20s  | %11s | %17s | %6.2f | %6.2f | %10d |\n",turma.getIdturma(),turma.getIdalunofk(),turma.getNomealuno(),turma.getNomedisc(),turma.getNomeprof(),turma.getN1(),turma.getN2(),turma.getPresenca());
				}
				
				System.out.println("+--------+------+-----------------------+-------------+-------------------+--------+--------+------------+"); 
				
				int opcao1;
				System.out.println("+=====================================+");
				System.out.println("| OPÇÕES:                             |");
				System.out.println("| 1 - LANÇAR NOTAS POR ID :           |");
				System.out.println("| 2 - LANCAR FREQUENCIA ID:           |");
				System.out.println("| 3 - SAIR:                           |");
				opcao1 = sc.nextInt();
				while(opcao1<3)
				{
					
					if(opcao1 == 1)
					{
						
						int idaluno;
						double n1;
						double n2;
						
						System.out.println("DIGITE AGORA O ID DO ALUNO PARA LANCAR NOTAS");
						idaluno =sc.nextInt();
						System.out.println("DIGITE AGORA NOTA N1");
						n1 = sc.nextDouble();
						System.out.println("DIGITE AGORA NOTA N2");
						n2 = sc.nextDouble();
						
						if(daologin.alteraNotas(idaluno, n1, n2))
						{
							System.out.println("ALTERADO COM SUCESSO");
						}
						else
						{
							System.out.println("ERRO AO ALTERAR");
						}
						
					}
					if(opcao1 == 2)
					{
						
						int idaluno;
						int presenca;
						
						System.out.println("DIGITE AGORA O ID DO ALUNO PARA LANCAR PRESENCA");
						idaluno = sc.nextInt();
						System.out.println("DIGITE O VALOR DA PRESENCA");
						presenca = sc.nextInt();
						
						if(daologin.alteraPresenca(idaluno,presenca))
						{
							System.out.println("ALTERADO COM SUCESSO");
						}
						else
						{
							System.out.println("ERRO AO ALTERAR");
						}
						
						
					}
						
					System.out.println("+=====================================+");
					System.out.println("| OPÇÕES:                             |");
					System.out.println("| 1 - LANÇAR NOTAS POR ID :           |");
					System.out.println("| 2 - LANCAR FREQUENCIA ID:           |");
					System.out.println("| 3 - SAIR:                           |");
					opcao1 = sc.nextInt();
					
				}
			}
			
			
			System.out.println("+=====================================+");
			System.out.println("| SISTEMA ACADEMICO                   |");
			System.out.println("| OPÇÕES:                             |");
			System.out.println("| 1 - MINHAS TURMAS:                  |");
			System.out.println("| 2 - SAIR:                           |");
			opcao = sc.nextInt();
			
		}
		
		
	}
	
	public static void aluno(int login) throws SQLException, InterruptedException
	{
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		DaoLogin daologin = new DaoLogin();
		
		System.out.println("+=====================================+");
		System.out.println("| SISTEMA ACADEMICO                   |");
		System.out.println("| OPÇÕES:                             |");
		System.out.println("| 1 - MEUS DADOS:                     |");
		System.out.println("| 2 - MINHA TURMA:                    |");
		System.out.println("| 3 - SAIR:                           |");
		opcao = sc.nextInt();
		
		while(opcao<3)
		{
			if(opcao == 1)
			{
				Alunof aluno = daologin.dadosAluno(login);
				
				
				System.out.println("+----------+-----------------------+-------------+-------------------+----------------+-------------+");
				System.out.println("|MATRICULA | NOME                  |  NASCIMENTO |  EMAIL            | DATA MATRICULA | CURSO       |");
				System.out.println("+----------+-----------------------+-------------+-------------------+----------------+-------------+");
				System.out.printf("| %8d | %20s  | %11s | %17s | %14s | %11s |\n",aluno.getIdaluno(),aluno.getNomealuno(),aluno.getDatanasc(),aluno.getEmail(),aluno.getDatamat(),aluno.getCurso());
				System.out.println("+----------+-----------------------+-------------+-------------------+----------------+-------------+");
			}
			if(opcao == 2)
			{
				ArrayList<Turma> lista = daologin.dadosTurma(login);
				System.out.println("+----------+-----------------------+-------------+-------------------+--------+--------+------------+");
				System.out.println("|COD TURMA | NOME                  |  DISCIPLINA |  PROFESSOR        |   N1   |   N2   | PRESENCA   |");
				System.out.println("+----------+-----------------------+-------------+-------------------+--------+--------+------------+");
				for (Turma turma : lista) {
					System.out.printf("| %8d | %20s  | %11s | %17s | %6.2f | %6.2f | %10d |\n",turma.getIdturma(),turma.getNomealuno(),turma.getNomedisc(),turma.getNomeprof(),turma.getN1(),turma.getN2(),turma.getPresenca());
				}
				
				System.out.println("+----------+-----------------------+-------------+-------------------+--------+--------+------------+"); 
				
			}
				
			
			System.out.println("+=====================================+");
			System.out.println("| SISTEMA ACADEMICO                   |");
			System.out.println("| OPÇÕES:                             |");
			System.out.println("| 1 - MEUS DADOS:                     |");
			System.out.println("| 2 - MINHA TURMA:                    |");
			System.out.println("| 3 - SAIR:                           |");
			opcao = sc.nextInt();
			
		}
		
	}
	
	

	public static void main(String[] args) throws SQLException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);

		
		String senha = null;
		String validacao;
		int login;
		
		System.out.println("+=====================================+");
		System.out.println("| SISTEMA ACADEMICO                   |");
		System.out.println("| DIGITE 0 PARA SAIR:                 |");
		System.out.println("| MATRICULA E SENHA:                  |");
		System.out.println("| DIGITE SUA MATRICULA:               |");
		login = sc.nextInt();

		while (login != 0) {

			DaoLogin daologin = new DaoLogin();
			validacao = daologin.loginUser(login);

			if (validacao!=null) {
				System.out.println("| DIGITE A SENHA:                     |");
				senha = sc1.nextLine();
				if (daologin.validaSenha(login, senha)) {
					System.out.println("SEJA BEM VINDO");
					System.out.println("LOGADO COMO "+validacao);
					
					if(validacao.equals("ALUNO"))
					{
						aluno(login);
					}
					if(validacao.equals("PROFESSOR"))
					{
						professor(login);
					}
					if(validacao.equals("SECRETARIA"))
					{
						
					}
					if(validacao.equals("COORDENADOR"))
					{
						
					}
					
					
				} else {
					System.out.println("SENHA INVALIDA");

				}

			} else {
				System.out.println("LOGIN INVALIDO");
			}
			
			System.out.println("+=====================================+");
			System.out.println("| SISTEMA ACADEMICO                   |");
			System.out.println("| DIGITE 0 PARA SAIR:                 |");
			System.out.println("| MATRICULA E SENHA:                  |");
			System.out.println("| DIGITE SUA MATRICULA:               |");
			login = sc.nextInt();
			

		}
		System.out.println("ATE MAIS");

	}

}
