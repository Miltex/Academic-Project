package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import controlador.Controlador;

public class PainelCadastrar extends JPanel{
	
	private JLabel aux;
	//private JLabel aux1;
	//private JLabel aux2;
	//private JLabel aux3;
	//private JLabel aux4;
	
	private JLabel instrucao;
	private JLabel nome;
	private JLabel sexo;
	private JLabel coeficiente;
	private JLabel nRegistros;
	
	private JTextField campoNome;
	private JTextField campoCoeficiente;
	private JTextField campoNRegistros;
	
	private JSeparator separador;
	private JSeparator separador1;
	
	private JRadioButton masculino, feminino;
	private ButtonGroup grupo;
	
	private JButton botaoCadastrar;
	private JButton botaoLimpar;
	
	private JPanel painelCampos;
	private JPanel painelBotoes;
	private JPanel painelAuxiliar;
	private JPanel painelInstrucao;
	
	public PainelCadastrar() throws IOException{
		
		aux = new JLabel("");
		//aux1 = new JLabel("");
		//aux2 = new JLabel("");
		//aux3 = new JLabel("");
		//aux4 = new JLabel("");
		instrucao = new JLabel("PREENCHA OS CAMPOS ABAIXO COM OS DADOS CORRESPONDENTES: ");
		nome = new JLabel("Nome: ");
		sexo = new JLabel("Sexo: ");
		coeficiente = new JLabel("Coeficiente: ");
		nRegistros = new JLabel("Nº de alunos cadastrados: ");
		
		separador = new JSeparator();
		separador1 = new JSeparator();
		
		botaoCadastrar = new JButton("Cadastrar");
		botaoLimpar = new JButton("Limpar");
		
		campoNome = new JTextField(20);
		campoCoeficiente = new JTextField(4);
		campoNRegistros = new JTextField(5);
				
		masculino = new JRadioButton("Masculino");
		feminino = new JRadioButton("Feminino");
		
		grupo = new ButtonGroup();
		grupo.add(masculino);
		grupo.add(feminino);
		masculino.setSelected(true);
		
		painelCampos = new JPanel(new GridLayout(8, 2, 5, 5));
		painelBotoes = new JPanel();
		painelAuxiliar = new JPanel();
		painelInstrucao = new JPanel();
		
		painelCampos.add(nome);
		painelCampos.add(campoNome);
		//painelCampos.add(aux);
		painelCampos.add(coeficiente);
		painelCampos.add(campoCoeficiente);
		//painelCampos.add(aux1);
		painelCampos.add(sexo);
		painelCampos.add(aux);
		painelCampos.add(masculino);
		painelCampos.add(feminino);
		painelCampos.add(separador);
		painelCampos.add(separador1);
		//painelCampos.add(aux2);
		//painelCampos.add(aux3);
		//painelCampos.add(aux4);
		painelCampos.add(nRegistros);
		painelCampos.add(campoNRegistros);
		Controlador controlador = Controlador.getInstance();
		int tam = controlador.numeroRegistros();
		campoNRegistros.setText(""+tam);
		campoNRegistros.setEditable(false);
		
		painelInstrucao.add(instrucao);
		painelBotoes.add(botaoCadastrar);
		painelBotoes.add(botaoLimpar);
		painelAuxiliar.add(painelCampos);
		
		this.setLayout(new BorderLayout(2, 2));
		this.add(painelInstrucao, BorderLayout.NORTH);
		this.add(painelAuxiliar, BorderLayout.CENTER);
		this.add(painelBotoes, BorderLayout.SOUTH);

		
	//Tratamento de eventos;
	botaoLimpar.addActionListener(
			new ActionListener(){
				
				public void actionPerformed(ActionEvent e){
					campoNome.setText("");
					campoCoeficiente.setText("");
				}
			}
	);
	
	botaoCadastrar.addActionListener(
			new ActionListener(){
				
				public void actionPerformed(ActionEvent e){
					
					boolean continuar = true;
					double c = 0;
					try{
						String nome = campoNome.getText().trim();
					do{	
						c = Double.parseDouble(campoCoeficiente.getText().trim());
						if(c < 0 || c > 100){
							campoCoeficiente.setText("");
							continuar = true;
						 }
						else{
							continuar = false;
						}
					}while(continuar == true);
						
						char s;
						
						if(masculino.isSelected()){
						   s = 'M';
						}
						else{
						   s = 'F';
						}
					
						Controlador controlador = Controlador.getInstance();
						controlador.cadastrarAluno(nome, s, c);
						int t = controlador.numeroRegistros();
						int matricula = 40000 + t;
						JOptionPane.showMessageDialog(PainelCadastrar.this, "Aluno cadastrado com sucesso!\n            Matrícula: "+ matricula,"OK",JOptionPane.INFORMATION_MESSAGE);
						//JOptionPane.showMessageDialog(PainelCadastrar.this, "Aluno cadastrado com sucesso!","OK",JOptionPane.INFORMATION_MESSAGE);
						
						campoNome.setText("");
						campoCoeficiente.setText("");
						int tam = controlador.numeroRegistros();
						campoNRegistros.setText(""+tam);

						//Falta desativar os botoes RadioButton
					}
					catch(NumberFormatException ex){//Excessão que ocorre quando é informado um valor incompativel com o tipo declarado
						JOptionPane.showMessageDialog(PainelCadastrar.this, "     Valor informado inválido!\n Informe os dados corretamente!","Advertência",JOptionPane.WARNING_MESSAGE);
						campoNome.setText("");
						campoCoeficiente.setText("");
					}
					catch(IllegalArgumentException ex){
						JOptionPane.showMessageDialog(PainelCadastrar.this, ex.getMessage());
					}
					catch(IOException ex){
						JOptionPane.showMessageDialog(PainelCadastrar.this, "Ocorreu um erro durante a escrita no arquivo","ERRO",JOptionPane.ERROR_MESSAGE);
						System.exit(1);
					}
				}
			}
	);
}

}
