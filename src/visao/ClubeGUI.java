package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controle.ClubeControle;
import modelo.Clube;

public class ClubeGUI extends JDialog{
	
	private JPanel painel;
	
	private JLabel labelId;
	private JTextField textId;
	
	private JLabel labelNome;
	private JTextField textNome;
	
	private JLabel labelTitulos;
	private JTextField textTitulos;

	private JLabel labelCidade;
	private JTextField textCidade;

	private JLabel labelTecnico;
	private JTextField textTecnico;
	
	private JButton botaoSalvar;	
	private JButton botaoLimpar;
	
	private EventoBotoes eventoBotoes;

	private EventoBotoes getEventoBotoes() {
		if (eventoBotoes ==  null) {
			eventoBotoes = new EventoBotoes();
		}		
		return eventoBotoes;
	}
	
	public ClubeGUI() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("Gerenciar Clubes");
		this.setModal(true);
		this.setSize(570, 410);
		this.setLocationRelativeTo(null);	
		this.setContentPane(getPainel());
		this.setVisible(true);
	}
	
	private JPanel getPainel() {
		if (painel == null) {
			painel = new JPanel();
			painel.setLayout(null);
			painel.add(getLabelId());
			painel.add(getTextId());
			
			painel.add(getLabelNome());
			painel.add(getTextNome());
			
			painel.add(getLabelTitulos());
			painel.add(getTextTitulos());

			painel.add(getLabelCidade());
			painel.add(getTextCidade());

			painel.add(getLabelTecnico());
			painel.add(getTextTecnico());
			
			painel.add(getBotaoSalvar());
			painel.add(getBotaoLimpar());
			
		}
		return painel;
	}
	
	private JLabel getLabelId() {
		
		if (labelId == null) {
			labelId = new JLabel("Id: ");
			labelId.setBounds(10, 10, 30, 25);
		}
		return labelId;
	}

	private JTextField getTextId() {		
		
		if (textId == null) {
			textId = new JTextField();
			textId.setEnabled(false);
			textId.setBounds(100, 10, 30, 25);
		}
		return textId;
	}

	
	private JLabel getLabelNome() {
		
		if (labelNome == null) {
			labelNome = new JLabel("Nome: ");
			labelNome.setBounds(10, 40, 50, 25);
		}
		return labelNome;
	}

	private JTextField getTextNome() {		
		
		if (textNome == null) {
			textNome = new JTextField();
			textNome.setBounds(100, 40, 300, 25);
		}
		return textNome;
	}
	
	private JLabel getLabelTitulos() {
		
		if (labelTitulos == null) {
			labelTitulos = new JLabel("Titulos: ");
			labelTitulos.setBounds(10, 70, 80, 25);
		}
		return labelTitulos;
	}

	private JTextField getTextTitulos() {		
		
		if (textTitulos == null) {
			textTitulos = new JTextField();
			textTitulos.setBounds(100, 70, 80, 25);
		}
		return textTitulos;
	}

	private JLabel getLabelCidade() {
		
		if (labelCidade == null) {
			labelCidade = new JLabel("Cidade: ");
			labelCidade.setBounds(10, 100, 80, 25);
		}
		return labelCidade;
	}

	private JTextField getTextCidade() {		
		
		if (textCidade == null) {
			textCidade = new JTextField();
			textCidade.setBounds(100, 100, 80, 25);
		}
		return textCidade;
	}

	private JLabel getLabelTecnico() {
		
		if (labelTecnico == null) {
			labelTecnico = new JLabel("Técnico: ");
			labelTecnico.setBounds(10, 130, 80, 25);
		}
		return labelTecnico;
	}

	private JTextField getTextTecnico() {		
		
		if (textTecnico == null) {
			textTecnico = new JTextField();
			textTecnico.setBounds(100, 130, 80, 25);
		}
		return textTecnico;
	}
	
	private JButton getBotaoSalvar() {
		if(botaoSalvar == null){
			botaoSalvar = new JButton("Salvar");
			botaoSalvar.setToolTipText("clique aqui para salvar");
			botaoSalvar.setBounds(30, 160, 100, 25);
			botaoSalvar.addActionListener(getEventoBotoes());
		}
		return botaoSalvar;
	}
	
	private JButton getBotaoLimpar() {
		if(botaoLimpar == null){
			botaoLimpar = new JButton("Limpar");
			botaoLimpar.setToolTipText("clique aqui para limpar");
			botaoLimpar.setBounds(160, 160, 100, 25);
			botaoLimpar.addActionListener(getEventoBotoes());
		}
		return botaoLimpar;
	}
	
	private void salvar() {
		String nome = getTextNome().getText();
		int titulos = Integer.parseInt(getTextTitulos().getText());
		String cidade = getTextCidade().getText();
		String tecnico = getTextTecnico().getText();

		ClubeControle controle = new ClubeControle();
		try {
			controle.salvarClube(nome, titulos, cidade, tecnico);			
			JOptionPane.showMessageDialog(null, "Sucesso ao salvar", "Sucesso", 
					JOptionPane.INFORMATION_MESSAGE);
			limparCampos();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar", "Erro", 
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private class EventoBotoes implements ActionListener{		
		public void actionPerformed(ActionEvent evento) {			
			if(evento.getSource() == getBotaoSalvar()){
				salvar();
			} else if (evento.getSource() == getBotaoLimpar()) {
				limparCampos();
			}
		}		
	}
	
	private void limparCampos() {
		getTextId().setText("");
		getTextNome().setText("");
		getTextTitulos().setText("");
		getTextCidade().setText("");
		getTextTecnico().setText("");
	}

	
}