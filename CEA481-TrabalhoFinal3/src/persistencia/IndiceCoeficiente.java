package persistencia;

//Construtor com dois atributos usado para ordenação por nome
public class IndiceCoeficiente {
	
	private int matricula;
	private double coeficiente;
	
	public IndiceCoeficiente(int m, double c){
		matricula= m;
		coeficiente = c;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public double getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(double coeficiente) {
		this.coeficiente = coeficiente;
	}

}
