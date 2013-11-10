package interfaceGrafica;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
/**
 * 
 * @author milton
 * Classe que monta a janela principal do software
 */
public class JanelaPrincipal extends JFrame{
	
	private static final long serialVersionUID = 1L;

	private JDesktopPane desktop = null;
	
	//Barra de menu e seus respectivos menus
	private JMenuBar barraMenu;
	private JMenu menuCadastrar;
	private JMenu menuConsultar;
	private JMenu menuEditar;
	private JMenu menuListar;
	private JMenu menuAjuda;
	
	//Itens de menus
	private JMenuItem novoAluno;
	private JMenuItem dadosAluno;
	private JMenuItem registro;
	private JMenuItem Sistema;
	private JMenuItem Desenvolvedores;
	private JMenuItem ensino;
	
	private JMenu subMenuListar;
	private JMenuItem nome;
	private JMenuItem matricula;
	private JMenuItem coeficiente;
	
	private PainelConsultar painelConsultar;
	private PainelCadastrar painelCadastrar;
	private PainelEditar painelEditar;
	private PainelListarNome painelListarNome;
	private PainelListarCoeficiente painelListarCoeficiente;
	private PainelListarMatricula painelListarMatricula;
	/*
	 * Construtor
	 */
	public JanelaPrincipal() throws IOException{
		super("GA (Gest�o Acad�mica)");
		
		desktop = new JDesktopPane();
		painelConsultar = new PainelConsultar();
		painelCadastrar = new PainelCadastrar();
		painelEditar = new PainelEditar();
		painelListarNome = new PainelListarNome();
		painelListarMatricula = new PainelListarMatricula();
		painelListarCoeficiente = new PainelListarCoeficiente();
		
		//Cria��o da barra de menu
		barraMenu = new JMenuBar();
		menuCadastrar = new JMenu("Cadastrar");
		menuConsultar = new JMenu("Consultar");
		menuEditar = new JMenu("Editar");
		menuListar = new JMenu("Listar");
		menuAjuda= new JMenu ("Ajuda");
		
		//Preenchimento da barra de menu
		barraMenu.add(menuCadastrar);
		barraMenu.add(menuConsultar);
		barraMenu.add(menuEditar);
		barraMenu.add(menuListar);
		barraMenu.add(menuAjuda);
		
		//Cria��o dos menus internos
		novoAluno = new JMenuItem("Novo Aluno");
		menuCadastrar.add(novoAluno);
		dadosAluno = new JMenuItem("Aluno");
		menuConsultar.add(dadosAluno);
		registro = new JMenuItem("Aluno");
		menuEditar.add(registro);
		
		nome = new JMenuItem("Nome");
		matricula = new JMenuItem("Matricula");
		coeficiente = new JMenuItem("Coeficiente");
		subMenuListar = new JMenu("Aluno");
		
		Sistema = new JMenuItem("Sistema");
		Desenvolvedores = new JMenuItem("Desenvolvido");
		ensino = new JMenuItem("UFOP");
		
		subMenuListar.add(nome);
		subMenuListar.add(matricula);
		subMenuListar.add(coeficiente);
		menuListar.add(subMenuListar);
		menuAjuda.add(Sistema);
		menuAjuda.add(Desenvolvedores);
		menuAjuda.add(ensino);
			
		this.add(desktop,BorderLayout.CENTER);
		this.setJMenuBar(barraMenu);
		this.setSize(500, 300);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		novoAluno.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
			// cria um JInternalFrame e adiciona no JDesktopPane
				JInternalFrame internal = new JInternalFrame("Cadastrar", false, true, false, false );
				desktop.add(internal);
				internal.add(painelCadastrar);
				internal.setSize(500, 300);
				internal.setLocation(0, 50);
				internal.setVisible(true);
				}
			}
		);
		
		dadosAluno.addActionListener(new ActionListener( ) {
			public void actionPerformed( ActionEvent e ) {
			// cria um JInternalFrame e adiciona no JDesktopPane
				JInternalFrame internal = new JInternalFrame("Consultar", false, true, false, false );
				desktop.add(internal);
				internal.add(painelConsultar);
				internal.setSize(500, 300);
				internal.setLocation(0, 350);
				internal.setVisible(true);
			
				}
			}
		);
	
		registro.addActionListener(new ActionListener( ) {
			public void actionPerformed( ActionEvent e ) {
			// cria um JInternalFrame e adiciona no JDesktopPane
				JInternalFrame internal = new JInternalFrame("Editar", false, true, false, false);
			
				desktop.add(internal);
				internal.add(painelEditar);
				internal.setSize(600,600);
				internal.setLocation(500, 50);
				internal.validate();
				internal.repaint();
				painelEditar.validate();
				painelEditar.repaint();
				painelEditar.setVisible(true);
				internal.setVisible(true);
				
				}
			}
		);
	
		nome.addActionListener(new ActionListener( ) {
			public void actionPerformed( ActionEvent e ) {
			// cria um JInternalFrame e adiciona no JDesktopPane
				JInternalFrame internal = new JInternalFrame("Listar por Nome", false, true, false, false );
				desktop.add(internal);
				internal.add(painelListarNome);
				internal.setSize(700,600);
				internal.setLocation(200, 0);
				internal.setVisible(true);
				}
			}
		);
	
		coeficiente.addActionListener(new ActionListener( ) {
			public void actionPerformed( ActionEvent e ) {
			// cria um JInternalFrame e adiciona no JDesktopPane
				JInternalFrame internal = new JInternalFrame("Listar por Coeficiente", false, true, false, false );
				desktop.add(internal);
				internal.add(painelListarCoeficiente);
				internal.setSize(700,600);
				internal.setLocation(300, 80);
				internal.setVisible(true);
				
				}
			}
		);
	
		matricula.addActionListener(new ActionListener( ) {
			public void actionPerformed( ActionEvent e ) {
			// cria um JInternalFrame e adiciona no JDesktopPane
				JInternalFrame internal = new JInternalFrame("Listar por Matr�cula", false, true, false, false );
				desktop.add(internal);
				internal.add(painelListarMatricula);
				internal.setSize(700,600);
				internal.setLocation(250, 35);
				internal.setVisible(true);
				
				}
			}
		);
		
		Sistema.addActionListener(
				new ActionListener( ) {
					public void actionPerformed(ActionEvent click){
						//remove(painelConteudo);
						JOptionPane.showMessageDialog(null, "Este software foi elaborado para ser utilizado " +
								"para cadastrar\nalunos, com o n�mero de matr�cula inicial de 40001.","Sobre o Sistema", JOptionPane.INFORMATION_MESSAGE );
						repaint();
					}
				}
		);
		
		Desenvolvedores.addActionListener(
				new ActionListener( ) {
					public void actionPerformed(ActionEvent click){
						//remove(painelConteudo);
						JOptionPane.showMessageDialog(null,"Programa desenvolvido por:\n\n=> Daniel Prato da Silva\n" +
								"=> Milton Ferreira Lima Filho\n\n" +
								"27/06/2009","Desenvolvedores",JOptionPane.INFORMATION_MESSAGE);
						repaint();
					}
				}
		);
		
		ensino.addActionListener(
				new ActionListener( ) {
					public void actionPerformed(ActionEvent click){
						//remove(painelConteudo);
						JOptionPane.showMessageDialog(null,"         Universidade Federal de Ouro Preto\n" +
								" ICEA (Instituto de Ciencias Exatas e Aplicadas) \n" +
								"          Campi Joao Monlevade, MG, Brasil","UFOP",JOptionPane.INFORMATION_MESSAGE);
						repaint();
					}
				}
		);
	
	}
}