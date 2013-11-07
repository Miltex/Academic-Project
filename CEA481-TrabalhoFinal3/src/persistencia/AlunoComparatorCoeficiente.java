package persistencia;

import java.util.Comparator;

public class AlunoComparatorCoeficiente implements Comparator<IndiceCoeficiente>{
		/*Método que faz a comparacao entre o atributo do objeto aluno e retorna 1
		 * caso o valor do primeiro seja maior que o do segundo, retorna -1 caso
		 * contrário.
		 */
		public int compare(IndiceCoeficiente a1, IndiceCoeficiente a2){
			if(a1.getCoeficiente() > a2.getCoeficiente()){
				return 1;
			}
			else{
				return -1;
			}	
	}

}