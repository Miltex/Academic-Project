package interfaceGrafica;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import persistencia.Aluno;

import controlador.Controlador;

	public class PainelConsultar extends JPanel{		

		private JLabel aux, aux1;
		
		private JLabel nome;
		private JLabel sexo;
		private JLabel matricula;
		private JLabel matricula1;
		private JLabel coeficiente;
		
		private JButton botaoConsultar;
		private JButton botaoLimpar;
		
		private JTextField campoNome;
		private JTextField campoSexo;
		private JTextField campoMatricula;
		private JTextField campoMatricula1;
		private JTextField campoCoeficiente;
		
		private JPanel painelCampos;
		private JPanel painelBotoes;
		private JPanel painelAuxiliar;
		
		public PainelConsultar(){
			
			aux = new JLabel("");
			aux1 = new JLabel("");
			nome = new JLabel("Nome: ");
			sexo = new JLabel("Sexo: ");
			matricula = new JLabel("INFORME A MATRICULA AQUI: ");
			matricula1 = new JLabel("Matricula: ");
			coeficiente = new JLabel("Coeficiente: ");
			
			botaoConsultar = new JButton("Consultar");
			botaoLimpar = new JButton("Limpar");
			
			campoNome = new JTextField(20);
			campoNome.setEditable(false);
			campoSexo = new JTextField(1);
			campoSexo.setEditable(false);
			campoMatricula = new JTextField(5);
			campoMatricula1 = new JTextField(5);
			campoMatricula1.setEditable(false);
			campoCoeficiente = new JTextField(4);
			campoCoeficiente.setEditable(false);
					
			painelCampos = new JPanel(new GridLayout(7, 2, 5, 5));
			painelBotoes = new JPanel();
			painelAuxiliar = new JPanel();
			
			painelCampos.add(matricula);
			painelCampos.add(campoMatricula);
			painelCampos.add(aux);
			painelCampos.add(aux1);
			painelCampos.add(matricula1);
			painelCampos.add(campoMatricula1);
			painelCampos.add(nome);
			painelCampos.add(campoNome);
			painelCampos.add(coeficiente);
			painelCampos.add(campoCoeficiente);
			painelCampos.add(sexo);
			painelCampos.add(campoSexo);
			
			painelBotoes.add(botaoConsultar);
			painelBotoes.add(botaoLimpar);
			painelAuxiliar.add(painelCampos);
			
			this.setLayout(new BorderLayout(5, 5));
			this.add(painelAuxiliar, BorderLayout.CENTER);
			this.add(painelBotoes, BorderLayout.SOUTH);
		
			//Tratamento de eventos
			botaoLimpar.addActionListener(
					new ActionListener(){
						
						public void actionPerformed(ActionEvent e){
							campoMatricula.setText("");
						}
					}
			);
						
			botaoConsultar.addActionListener(
					new ActionListener( ) {
						public void actionPerformed( ActionEvent e ) {
							Aluno aluno;
							try {
								int matricula = Integer.parseInt(campoMatricula.getText().trim());
								
								if(matricula > 40000) { 
									Controlador controlador = Controlador.getInstance();
									aluno = controlador.consultarAluno(matricula);
								
									if(aluno.getMatricula() > 0) {
										campoMatricula1.setText(""+aluno.getMatricula());
										campoNome.setText(""+aluno.getNome());
										campoCoeficiente.setText(""+aluno.getCoeficiente());
										campoSexo.setText(""+aluno.getSexo());
									}
									else{
										JOptionPane.showMessageDialog(PainelConsultar.this, "Não existe conta com o número informado.", 
												"Atenção", JOptionPane.INFORMATION_MESSAGE);
								
										campoNome.setText("");
										campoCoeficiente.setText("");
										campoSexo.setText("");
									}
								}
								else {
									JOptionPane.showMessageDialog(PainelConsultar.this, "Matrícula inválida! Informe novamente a matrícula!", 
											"Atenção", JOptionPane.WARNING_MESSAGE);
									   campoMatricula.setText("");
								}
							}
							catch(NumberFormatException ex) {
								JOptionPane.showMessageDialog(PainelConsultar.this, "       Valor informado inválido!\nInforme novamente a matrícula!", 
										"Atenção", JOptionPane.WARNING_MESSAGE);
								   campoMatricula.setText("");
							}							
							catch (FileNotFoundException ex) {
								JOptionPane.showMessageDialog(PainelConsultar.this, "Erro ao abrir o arquivo!",
										"Erro", JOptionPane.ERROR_MESSAGE);
								System.exit(1);
							}						
							catch (IOException ioException) {
								JOptionPane.showMessageDialog(PainelConsultar.this, "Matrícula Inexistente!",
										"Atenção", JOptionPane.WARNING_MESSAGE);
								campoMatricula.setText("");
							}						
						}					
					}
			);
			
		}

}