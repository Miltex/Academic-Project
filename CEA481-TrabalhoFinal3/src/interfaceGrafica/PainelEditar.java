package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;


import persistencia.Aluno;
import controlador.Controlador;

public class PainelEditar extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel aux, aux1, aux2;
	private JLabel alteracoes;
	private JLabel instrucao;
	private JLabel instrucao1;
	private JLabel invisivel;
	private JLabel invisivel1;
	private JLabel nome;
	private JLabel resultNome;
	private JLabel sexo;
	private JLabel resultSexo;
	private JLabel matricula;
	private JLabel resultMatricula;
	private JLabel coeficiente;
	private JLabel resultCoeficiente;
	
	private JButton botaoConsultar;
	private JButton botaoAlterar;
	private JButton botaoCancelar;
	
	private ButtonGroup grupo;
	private JRadioButton radioNome;
	private JRadioButton radioCoeficiente;
	private JRadioButton radioSexo;
	
	private JTextField campoNome;
	private JTextField campoResultNome;
	private JTextField campoSexo;
	private JTextField campoResultSexo;
	private JTextField campoMatricula;
	private JTextField campoResultMatricula;
	private JTextField campoCoeficiente;
	private JTextField campoResultCoeficiente;
	
	private JSeparator separador;
	private JSeparator separador1;
	
	private JPanel painelCampos;
	private JPanel painelBotoes;
	private JPanel painelInstrucao;
	private JPanel painelAuxiliar;

	
	public PainelEditar(){
				
		aux = new JLabel("");
		aux1 = new JLabel("");
		aux2 = new JLabel("");
		alteracoes = new JLabel("RESULTADO DAS ALTERAÇÕES: ");
		invisivel = new JLabel("");
		invisivel1 = new JLabel("");
		instrucao = new JLabel("INFORME A MATRÍCULA QUE DESEJA ALTERAR E EM SEGUIDA CLIQUE EM CONSULTAR");
		instrucao1 = new JLabel("ESCOLHA A OPÇÃO QUE DESEJA ALTERAR: ");
		nome = new JLabel("Nome: ");
		resultNome = new JLabel("Nome: ");
		sexo = new JLabel("Sexo: ");
		resultSexo = new JLabel("Sexo: ");
		matricula = new JLabel("Matricula: ");
		resultMatricula = new JLabel("Matricula: ");
		coeficiente = new JLabel("Coeficiente: ");
		resultCoeficiente = new JLabel("Coeficiente: ");
		
		botaoConsultar = new JButton("Consultar");
		botaoAlterar = new JButton("Alterar");
		botaoCancelar = new JButton("Cancelar");
		
		separador = new JSeparator();
		separador1 = new JSeparator();
		
		campoNome = new JTextField(20);
		campoNome.setEditable(false);
		campoResultNome = new JTextField(20);
		campoResultNome.setEditable(false);
		campoSexo = new JTextField(1);
		campoSexo.setEditable(false);
		campoResultSexo = new JTextField(1);
		campoResultSexo.setEditable(false);
		campoMatricula = new JTextField(5);
		campoResultMatricula = new JTextField(5);
		campoResultMatricula.setEditable(false);
		campoCoeficiente = new JTextField(4);
		campoCoeficiente.setEditable(false);
		campoResultCoeficiente = new JTextField(4);
		campoResultCoeficiente.setEditable(false);
		
		radioNome = new JRadioButton("Nome");
		radioCoeficiente = new JRadioButton("Coeficiente");
		radioSexo = new JRadioButton("Sexo");
		grupo = new ButtonGroup();
		grupo.add(radioNome);
		grupo.add(radioSexo);
		grupo.add(radioCoeficiente);
		
		painelCampos = new JPanel(new GridLayout(15, 2, 5, 5));
		painelBotoes = new JPanel();
		painelAuxiliar = new JPanel();
		painelInstrucao = new JPanel();
		
		painelCampos.add(matricula);
		painelCampos.add(campoMatricula);
		painelCampos.add(nome);
		painelCampos.add(campoNome);
		painelCampos.add(coeficiente);
		painelCampos.add(campoCoeficiente);
		painelCampos.add(sexo);
		painelCampos.add(campoSexo);
		painelCampos.add(instrucao1);
		painelCampos.add(radioNome);
		painelCampos.add(invisivel);
		painelCampos.add(radioCoeficiente);
		painelCampos.add(radioSexo);
		painelCampos.add(invisivel1);
		painelCampos.add(radioSexo);
		painelCampos.add(aux);
		painelCampos.add(aux1);
		painelCampos.add(separador);
		painelCampos.add(separador1);
		painelCampos.add(alteracoes);
		painelCampos.add(aux2);
		painelCampos.add(resultMatricula);
		painelCampos.add(campoResultMatricula);
		painelCampos.add(resultNome);
		painelCampos.add(campoResultNome);
		painelCampos.add(resultCoeficiente);
		painelCampos.add(campoResultCoeficiente);
		painelCampos.add(resultSexo);
		painelCampos.add(campoResultSexo);
		
		painelBotoes.add(botaoConsultar);
		painelBotoes.add(botaoAlterar);
		painelBotoes.add(botaoCancelar);
		painelAuxiliar.add(painelCampos);
		painelInstrucao.add(instrucao);
				
		this.setLayout(new BorderLayout(5, 5));
		this.add(painelInstrucao, BorderLayout.NORTH);
		this.add(painelAuxiliar, BorderLayout.CENTER);
		this.add(painelBotoes, BorderLayout.SOUTH);
		this.setVisible(true);
	
	botaoCancelar.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//PODE SER MELHORADO.
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Feche a janela Editar !","Atenção!", JOptionPane.WARNING_MESSAGE );
				}
			}
	);
	
	radioNome.addItemListener(
			new ItemListener(){
				public void itemStateChanged(ItemEvent e){
					if(radioNome.isSelected()){
					   campoNome.setEditable(true);
					}
					else{
					   campoNome.setEditable(false);
					}
				}
			}
	);
	
	radioSexo.addItemListener(
			new ItemListener(){
				public void itemStateChanged(ItemEvent e){
					if(radioSexo.isSelected()){
					   campoSexo.setEditable(true);
					}
					else{
					   campoSexo.setEditable(false);
					}
				}
			}
	);
	
	radioCoeficiente.addItemListener(
			new ItemListener(){
				public void itemStateChanged(ItemEvent e){
					if(radioCoeficiente.isSelected()){
						campoCoeficiente.setEditable(true);
					}
					else{
						campoCoeficiente.setEditable(false);
						
					}
				}
			}
	);
	
	botaoConsultar.addActionListener(
			new ActionListener( ) {
				public void actionPerformed( ActionEvent e ) {
					Aluno aluno = null;
					try {
						int matricula = Integer.parseInt(campoMatricula.getText().trim());
						
						if(matricula > 40000) { 
							Controlador controlador = Controlador.getInstance();
							aluno = controlador.consultarAluno(matricula);
						
								campoNome.setText(""+aluno.getNome());
								campoCoeficiente.setText(""+aluno.getCoeficiente());
								campoSexo.setText(""+aluno.getSexo());
						}
						else {
							JOptionPane.showMessageDialog(PainelEditar.this, "Matrícula inválida! Informe sua matrícula!", 
									"Atenção", JOptionPane.INFORMATION_MESSAGE);
								campoMatricula.setText("");
						}
					}
					catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(PainelEditar.this, "       Valor informado inválido!\nInforme novamente a matrícula!", 
								"Atenção", JOptionPane.INFORMATION_MESSAGE);
						   campoMatricula.setText("");
					}							
					catch (FileNotFoundException ex) {
						JOptionPane.showMessageDialog(PainelEditar.this, "Erro ao abrir o arquivo!",
								"Erro", JOptionPane.ERROR_MESSAGE);
						System.exit(1);
					}						
					catch (IOException ioException) {
						JOptionPane.showMessageDialog(PainelEditar.this, "Matrícula Inexistente!",
								"Atenção", JOptionPane.WARNING_MESSAGE);
						campoMatricula.setText("");
					}						
				}					
			}
	);
	
	botaoAlterar.addActionListener(
			new ActionListener(){
				
				public void actionPerformed(ActionEvent e){
					
					boolean continuar = true;
					double c = 0;
					try{
						String nome = campoNome.getText().trim();
						int m = Integer.parseInt(campoMatricula.getText().trim());
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
						
						String s;
						char sex;
						
						s = campoSexo.getText();
						s = s.toUpperCase();
						sex = s.charAt(0);
						
						if(sex != 'M' && sex != 'F'){
							JOptionPane.showMessageDialog(PainelEditar.this, "Sexo inválido! Informe <M> ou <F>","Atenção",JOptionPane.WARNING_MESSAGE);
							campoSexo.setText("");
							return;
							
						}

						Aluno aluno;
						Controlador controlador = Controlador.getInstance();
						aluno = controlador.consultarAluno(m);
						//Campos anteriores
						campoNome.setText(""+aluno.getNome());
						campoCoeficiente.setText(""+aluno.getCoeficiente());
						campoSexo.setText(""+aluno.getSexo());
						controlador.editarAluno(m, nome, sex, c);
						JOptionPane.showMessageDialog(PainelEditar.this, "Registro alterado com sucesso!","OK",JOptionPane.INFORMATION_MESSAGE);
						aluno = controlador.consultarAluno(m);
					
						campoMatricula.setText("");
						
						campoNome.setEditable(false);
						campoCoeficiente.setEditable(false);
						campoSexo.setEditable(false);	
						
						campoResultMatricula.setText(""+aluno.getMatricula());
						campoResultNome.setText(""+aluno.getNome());
						campoResultCoeficiente.setText(""+aluno.getCoeficiente());
						campoResultSexo.setText(""+aluno.getSexo());
						

					}
					catch(NumberFormatException ex){//Excessão que ocorre quando é informado um valor incompativel com o tipo declarado
						JOptionPane.showMessageDialog(PainelEditar.this, "       Valor informado inválido!\nInforme novamente a matrícula!","Atenção",JOptionPane.INFORMATION_MESSAGE);
						//campoCoeficiente.setText("");
						campoMatricula.setText("");
					}
					catch(IllegalArgumentException ex){
						JOptionPane.showMessageDialog(PainelEditar.this, ex.getMessage());
					}
					catch(IOException ex){
						JOptionPane.showMessageDialog(PainelEditar.this, "Ocorreu um erro durante a escrita no arquivo","ERRO",JOptionPane.ERROR_MESSAGE);
						//System.exit(1);
					}
				}
			}
			);

	}
}
