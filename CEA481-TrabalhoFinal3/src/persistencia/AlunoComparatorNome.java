package persistencia;

import java.util.Comparator;

public class AlunoComparatorNome implements Comparator<IndiceNome>{
	
		public int compare(IndiceNome a1, IndiceNome a2){
			int nomeComparacao = a1.getNome().compareTo(a2.getNome()); // compara nome

			if (nomeComparacao != 0){
				return nomeComparacao;
			} 
			
			return nomeComparacao;
		}

}
