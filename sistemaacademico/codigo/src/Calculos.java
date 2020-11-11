import modelof.Alunof;

public class Calculos {
	
	public String calculaResultadoFinal(float n1, float n2, int frequencia)
	{
		String resultado = "";
		int frequenciaAux = 75/100 * 80;
		if(frequencia <= frequenciaAux)
		{
			resultado = "Reprovado por falta.";
		}
		else
		{
			double mediaFinal = (n1 * 0.4) + (n2 * 0.6);
			if(mediaFinal < 6)
			{
				resultado = "Reprovado por média.";
			}
			else
			{
				resultado = "Aprovado!";
			}
		}
		return resultado;
	}
	
	public String cadastarNotasFrequencias(int idAluno, float n1, float n2, int frequencia) throws Exception
	{
		if(n1 > 10 || n1 < 0)
		{
			throw new Exception("Valor inválido para N1");
		}
		else
		{
			if(n2 > 10 || n2 < 0)
			{
				throw new Exception ("Valor inválido para N2");
			}
			else
			{
				if(frequencia > 80 || frequencia < 0)
				{
					throw new Exception("Valor inválido para frequência");
				}
				else
				{
					AlunoDao alunoDao = new AlunoDao();
					Alunof aluno = alunoDao.getAlunoId(idAluno);
					aluno.setN1(n1);
					aluno.setN2(n2);
					aluno.setFrequencia(frequencia);
					alunoDao.cadastarNotaFrequencia(aluno);
					return "Notas e frequência cadastradas com sucesso!";
				}
			}
		}
	}
}

	