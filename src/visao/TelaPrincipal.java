package visao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
		
	private JPanel painel;
	private JMenuBar barraMenu;
	private JMenu menuGerenciar;
	private JMenuItem menuItemClube;
	private JMenuItem menuItemJogador;
	private EventoMenus eventoMenus;
		
		/*
		private JPanel getPainel() {
			if (painel == null) {
				painel = new JPanel();
				painel.setLayout(null);			
			}
			return painel;
		}
		*/
	private JMenuBar getBarraMenu() {
		if (barraMenu == null) {
			barraMenu = new JMenuBar();
			barraMenu.add(getMenuGerenciar()); // barra -> menuGerenciar
		}
		return barraMenu;
	}
	
	private JMenu getMenuGerenciar() {
		if (menuGerenciar == null) {
			menuGerenciar = new JMenu("Gerenciar");
			menuGerenciar.add(getMenuItemClube()); //menuGerenciar -> menuItemCurso
			menuGerenciar.add(getMenuItemJogador()); //menuGerenciar -> menuItemAluno
		}
		return menuGerenciar;
	}
		
	private JMenuItem getMenuItemJogador() {
		if (menuItemJogador == null) {
			menuItemJogador = new JMenuItem("Jogadores");
			menuItemJogador.addActionListener(getEventoMenus());			
		}
		return menuItemJogador;
	}
	
	private JMenuItem getMenuItemClube() {
		if (menuItemClube == null) {
			menuItemClube = new JMenuItem("Clube");
			menuItemClube.addActionListener(getEventoMenus());			
		}
		return menuItemClube;
	}
		
	private EventoMenus getEventoMenus() {
		if (eventoMenus == null) {
			eventoMenus = new EventoMenus(); 
		}
		return eventoMenus;
	}

	public TelaPrincipal() {
		super("Biblioteca");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setContentPane(getPainel()); //adiciona painel
		this.setJMenuBar(getBarraMenu()); //adiciona o menu
		this.setSize(800, 600);
		this.setLocationRelativeTo(null); // centraliza	a tela
		this.setVisible(true);		
	}
	
		
	
	private class EventoMenus implements ActionListener{		
		public void actionPerformed(ActionEvent evento) {			
			if(evento.getSource() == getMenuItemClube()){
				new ClubeGUI();
			} else if (evento.getSource() == getMenuItemJogador()) {
				new JogadorGUI();
			} 
		}		
	}
	
}