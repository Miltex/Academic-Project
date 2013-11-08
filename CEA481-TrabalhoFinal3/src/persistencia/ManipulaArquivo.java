package persistencia;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManipulaArquivo{
	
	private RandomAccessFile arquivo = null;
	
	public void abrirArquivo() throws FileNotFoundException{
		
			arquivo = new RandomAccessFile("cadastrosAlunos.txt", "rw"); 
	}
	
	public int tamanhoArquivo() throws IOException{
		
		return (int) arquivo.length();
	}
	
	public void fecharArquivo() throws IOException{
		
			if(arquivo != null){
			   arquivo.close();
			}
	}
	
	
	public void adicionarRegistros(Aluno aluno) throws IOException{

		arquivo.seek((aluno.getMatricula() - 40001) * Aluno.SIZE);
		gravar(aluno);
		
	}
	
	private void gravar(Aluno aluno) throws IOException{
		
			arquivo.writeInt(aluno.getMatricula());
			formataNome(aluno.getNome());
			arquivo.writeDouble(aluno.getCoeficiente());		
			arquivo.writeChar(aluno.getSexo());	
	}

	private void formataNome(String nome) throws IOException{
		
		StringBuffer buffer = null;
		if (nome != null)
			buffer = new StringBuffer(nome);
		else
			buffer = new StringBuffer(30);
		buffer.setLength(30);
		arquivo.writeChars(buffer.toString());
	}
	
	
	public Aluno consultaRegistro(int m) throws IOException{
		Aluno aluno = null;
		
		if(m > 40000 && arquivo != null){
				aluno = lerRegistro(m);
		} 	
		return aluno;
	}
	
	public Aluno lerRegistro(int m) throws IOException{
		arquivo.seek((m - 40001) * Aluno.SIZE);
			
		Aluno aluno = new Aluno();
		aluno.setMatricula(arquivo.readInt());
		aluno.setNome(leNome());
		aluno.setCoeficiente(arquivo.readDouble());
		aluno.setSexo(arquivo.readChar());
		
		return aluno;
	}
	
	private String leNome() throws IOException {
		char nome[] = new char[30], temp;

		for (int i = 0; i < nome.length; i++) {
			temp = arquivo.readChar();
			nome[i] = temp;
		} 
		return new String(nome).replace('\0', ' ');
	}
	
	
	public void alteraRegistro(Aluno aluno) throws IOException{

		adicionarRegistros(aluno);
					   
	}
	
	public String imprimiRegistros(int op, int opc) throws IOException{
	

	String texto = "MATR�CULA\t\t              NOME\t\t\t                 COEFICIENTE\n\n";
	
	if(arquivo != null){
		int m = 40001;
		int cont = 0;
		Aluno aluno = null;
		Aluno aluno1 = null;
		int tamanho = tamanhoArquivo();
		tamanho = tamanho/Aluno.SIZE;	

		switch(op){
		
		case 1:
				
		if(opc == 'C'){
			do{
				aluno = lerRegistro(m);
				texto = texto + "  " + aluno.getMatricula()+ "\t\t" + aluno.getNome()+ "\t\t\t" + aluno.getCoeficiente() + "\n";
				m++;
				cont++;
			}while(cont < tamanho);
		}
		
		if(opc == 'D'){
		   m = 40000 + tamanho;
		   do{
		      aluno = lerRegistro(m);
			  texto = texto + "  " + aluno.getMatricula()+ "\t\t" + aluno.getNome()+ "\t\t\t" + aluno.getCoeficiente() + "\n";
		      m--;
		      tamanho--;
		   }while(tamanho > 0);
		}
		break;
	
		case 2:

			List<IndiceNome> lista = new ArrayList<IndiceNome>();
			do{
			   aluno = lerRegistro(m);
			   lista.add(new IndiceNome (aluno.getMatricula(), aluno.getNome()));
			   m++;
			   cont++;
			}while(cont < tamanho);
			Collections.sort(lista, new AlunoComparatorNome());
		
				if(opc == 'C'){
					for(int i = 0; i < tamanho; ++i){
						IndiceNome nome = lista.get(i);
						aluno1 = lerRegistro(nome.getMatricula());
						texto = texto + "  " + aluno1.getMatricula()+ "\t\t" + aluno1.getNome()+ "\t\t\t" + aluno1.getCoeficiente() + "\n";
					}
				}
					
				if(opc == 'D'){
				   Collections.reverse(lista);
				      for(int i = 0; i < tamanho; ++i){
					     IndiceNome nome = lista.get(i);
						 aluno1 = lerRegistro(nome.getMatricula());
						 texto = texto + "  " + aluno1.getMatricula()+ "\t\t" + aluno1.getNome()+ "\t\t\t" + aluno1.getCoeficiente() + "\n";
						}
				}
				break;
				
		case 3:

			ArrayList<IndiceCoeficiente> lista1 = new ArrayList<IndiceCoeficiente>();

				do{
				   aluno = lerRegistro(m);
				   lista1.add(new IndiceCoeficiente (aluno.getMatricula(), aluno.getCoeficiente()));
				   m++;
				   cont++;
				}while(cont < tamanho);
				Collections.sort(lista1, new AlunoComparatorCoeficiente());
				
				if(opc == 'C'){
					for(int i = 0; i < tamanho; ++i){
						IndiceCoeficiente coeficiente = lista1.get(i);
						aluno1 = lerRegistro(coeficiente.getMatricula());
						texto = texto + "  " + aluno1.getMatricula()+ "\t\t" + aluno1.getNome()+ "\t\t\t" + aluno1.getCoeficiente() + "\n";
					}
				}
				if(opc == 'D'){
					Collections.reverse(lista1);
					for(int i = 0; i < tamanho; ++i){
						IndiceCoeficiente coeficiente = lista1.get(i);
						aluno1 = lerRegistro(coeficiente.getMatricula());
						texto = texto + "  " + aluno1.getMatricula()+ "\t\t" + aluno1.getNome()+ "\t\t\t" + aluno1.getCoeficiente() + "\n";
					}
				}
			break;
			}
		}
	return texto;
	}
}