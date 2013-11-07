package persistencia;

//Construtor com dois atributos usado para ordenação por nome
public class IndiceNome {

	private int matricula;
	private String nome;
	
	public IndiceNome(int m, String n){
		matricula= m;
		nome = n;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
