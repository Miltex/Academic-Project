package persistencia;

import java.io.IOException;

public class Aluno{
	private String nome;
	private char sexo;
	private int matricula;
	private double coeficiente;	
	public final static int SIZE = 74;

	//Construtor defoult sem parâmetros
	public Aluno(){
	}
	
	//Construtor padrão com quatro atributos
	public Aluno(String n, char s, double c, int m){
		nome = n;
		sexo = s;
		coeficiente = c;
		matricula = gerarMatricula(m);	
	}
	
	//Método usado para cadastrar alunos
	public void cadastraAluno(ManipulaArquivo a, Aluno aluno) throws IOException{
		
		a.adicionarRegistros(aluno);		
	}
	
	//Método chamado pelo construtor para gerar a matrícula.
	private int gerarMatricula(int m){
		
		int mat = 40001;
	
		mat = mat + (m / SIZE);
		
		return mat;
	}
	
	//Método que consulta os dados de um aluno através de matrícula fornecida pelo usuário.
	public Aluno consultaAluno(ManipulaArquivo a, int m) throws IOException{
				
		return a.consultaRegistro(m);
	}
	
	//Método que altera os dados de um aluno correspondente ao número de matrícula.
	public void alteraAluno(ManipulaArquivo a, Aluno aluno) throws IOException{
		
		a.alteraRegistro(aluno);
		 	   
	}
	
	//Método que imprime na tela os dados do aluno correspondente a opcao do usuário
	public String imprimeAluno(ManipulaArquivo a, int op, char opOrdenacao) throws IOException{
		String texto = null;

		texto = a.imprimiRegistros(op, opOrdenacao);
		System.out.println("" + op);
		
		return texto;
	}
	
	//MÉTODOS SET E GET
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
