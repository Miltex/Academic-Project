package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controlador.Controlador;

public class PainelListarMatricula extends JPanel{

	private JLabel titulo;
	
	private ButtonGroup grupo;
	private JRadioButton crescente, decrescente;
	
	private JTextArea campoLista;
	private JScrollPane barraRolagem;
	
	private JButton botaoListar;

	private JPanel painelTitulo;
	private JPanel painelAuxiliar;
	private JPanel painelBotoes;
	
	public PainelListarMatricula(){
		
		titulo = new JLabel("DESEJA IMPRIMIR A RELAÇÃO DE ALUNOS ORDENADAS POR MATRÍCULA: ");
		campoLista = new JTextArea(" ", 30, 55);
		campoLista.setEditable(false);//Bloqueia a area de texto para edição
		barraRolagem = new JScrollPane(campoLista);//Cria barra de rolagem a area de texto
		barraRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		barraRolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		botaoListar = new JButton("Listar");
		
		painelTitulo = new JPanel();
		painelAuxiliar = new JPanel();
		painelBotoes = new JPanel();
		
		grupo = new ButtonGroup();
		crescente = new JRadioButton("Crescente ");
		decrescente = new JRadioButton("Decrescente ");
		grupo.add(crescente);
		grupo.add(decrescente);
		crescente.setSelected(true);
		
		painelTitulo.add(titulo);
		painelTitulo.add(crescente);
		painelTitulo.add(decrescente);
		
		painelAuxiliar.add(barraRolagem);
		painelBotoes.add(botaoListar);
		
		this.setLayout(new BorderLayout(5, 5));
		this.add(painelTitulo, BorderLayout.NORTH);
		this.add(painelAuxiliar, BorderLayout.CENTER);
		this.add(painelBotoes, BorderLayout.SOUTH);
		
		botaoListar.addActionListener(
				new ActionListener(){
					
					public void actionPerformed(ActionEvent e){
						
						try{
						char opcaoOrdenacao = 0;
						int opcao = 1;
							if(crescente.isSelected()){
							   opcaoOrdenacao = 'C';
							}
							else{
							   opcaoOrdenacao = 'D';
							}
							
						Controlador controlador = Controlador.getInstance();
						String txt = controlador.listarAluno(opcao, opcaoOrdenacao);
						campoLista.setText(txt);
						
						}
						catch(NumberFormatException ex){//Excessão que ocorre quando é informado um valor incompativel com o tipo declarado
							JOptionPane.showMessageDialog(PainelListarMatricula.this, "O valor informado não é valido!");
						}
						catch(IllegalArgumentException ex){
							JOptionPane.showMessageDialog(PainelListarMatricula.this, ex.getMessage());
						}
						catch(IOException ex){
							JOptionPane.showMessageDialog(PainelListarMatricula.this, "Ocorreu um erro durante a leitura no arquivo");
							System.exit(1);
						}
					}
				}
		);


	}

}
