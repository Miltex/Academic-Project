package persistencia;

import java.io.IOException;

public class Aluno{
	
	private String nome;
	private char sexo;
	private int matricula;
	private double coeficiente;	
	public final static int SIZE = 74;

	//Construtor default
	public Aluno(){
	}
	
	//Construtor padrao com quatro atributos
	public Aluno(String n, char s, double c, int m){
		nome = n;
		sexo = s;
		coeficiente = c;
		matricula = gerarMatricula(m);	
	}
	
	//M�todo usado para cadastrar alunos
	public void cadastraAluno(ManipulaArquivo a, Aluno aluno) throws IOException{
		
		a.adicionarRegistros(aluno);		
	}
	
	//M�todo chamado pelo construtor para gerar a matr�cula.
	private int gerarMatricula(int m){
		
		int mat = 40001;
	
		mat = mat + (m / SIZE);
		
		return mat;
	}
	
	//M�todo que consulta os dados de um aluno atrav�s de matr�cula fornecida pelo usu�rio.
	public Aluno consultaAluno(ManipulaArquivo a, int m) throws IOException{
				
		return a.consultaRegistro(m);
	}
	
	//M�todo que altera os dados de um aluno correspondente ao n�mero de matr�cula.
	public void alteraAluno(ManipulaArquivo a, Aluno aluno) throws IOException{
		
		a.alteraRegistro(aluno);
		 	   
	}
	
	//M�todo que imprime na tela os dados do aluno correspondente a opcao do usu�rio
	public String imprimeAluno(ManipulaArquivo a, int op, char opOrdenacao) throws IOException{
		String texto = null;

		texto = a.imprimiRegistros(op, opOrdenacao);
		System.out.println("" + op);
		
		return texto;
	}
	
	//M�TODOS SET E GET
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public double getCoeficiente() {
		return coeficiente;
	}
	public void setCoeficiente(double coeficiente) {
		this.coeficiente = coeficiente;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
}
