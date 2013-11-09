package controlador;

import java.io.FileNotFoundException;
import java.io.IOException;

import persistencia.Aluno;
import persistencia.ManipulaArquivo;

public class Controlador {
	
	private static Controlador controlador = null;
	private ManipulaArquivo arquivo;
	
	private Controlador() throws FileNotFoundException {
		arquivo = new ManipulaArquivo();
		arquivo.abrirArquivo();	
	}
	
	public static Controlador getInstance() throws FileNotFoundException {
		if(controlador == null) {
			controlador = new Controlador();
		}
		return controlador;
	}
	
	public void cadastrarAluno(String nome, char sexo, double coeficiente) throws IllegalArgumentException, IOException {
		int matricula = arquivo.tamanhoArquivo();
		Aluno aluno = new Aluno(nome, sexo, coeficiente, matricula);
		aluno.cadastraAluno(arquivo, aluno);
	}
	
	public Aluno consultarAluno(int m) throws NumberFormatException, IOException{
		Aluno aluno = new Aluno();
		return aluno.consultaAluno(arquivo, m);
	}
	
	public void editarAluno(int m, String nome, char sexo, double coeficiente) throws NumberFormatException, IOException{
		int matricula = 40001; 
		Aluno aluno = null;
		matricula = (m - matricula) * Aluno.SIZE;
		aluno = new Aluno(nome, sexo, coeficiente, matricula);
		aluno.alteraAluno(arquivo, aluno);
	}
	
	public String listarAluno(int op, char opOrdenacao) throws IOException{
		Aluno aluno = new Aluno();
		String texto = null;
		texto = aluno.imprimeAluno(arquivo, op, opOrdenacao);
		
		return texto;
	}
	
	public int numeroRegistros() throws IOException{
		int tam = arquivo.tamanhoArquivo();
		return tam/Aluno.SIZE;
	}
}

