package visao;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import controle.*;
import modelo.*;

import java.text.SimpleDateFormat;

public class JogadorGUI extends JDialog{
	
	//id, nome, Apelido, altuAltura, peso, posicao, num_camisa
	
	private JPanel painel;
	
	private JLabel labelId;
	private JTextField textId;
	
	private JLabel labelNome;
	private JTextField textNome;
	
	private JLabel labelApelido;
	private JTextField textApelido;
	
	private JLabel labelAltura;
	private JTextField textAltura;
	
	private JLabel labelPeso;
	private JTextField textPeso;
	
	private JLabel labelPosicao;
	private JTextField textPosicao;
	
	private JLabel labelNum_camisa;
	private JTextField textNum_camisa;
	
	private JLabel labelClubes;
	private JComboBox<Clube> comboBoxClubes;
		
	
	private JButton botaoSalvar;
	private JButton botaoLimpar;
	private EventoBotoes eventoBotoes ;
	

	public JogadorGUI() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("Gerenciar Jogadores");
		this.setModal(true); // bloqueia a janela principal
		this.setSize(570, 410);
		this.setLocationRelativeTo(null); // centAlturaliza	a tela	
		this.setContentPane(getPainel()); //adiciona painel
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
			painel.add(getLabelApelido());
			painel.add(getTextApelido());
			painel.add(getLabelAltura());
			painel.add(getTextAltura());
			painel.add(getLabelPeso());
			painel.add(getTextPeso());
			painel.add(getLabelPosicao());
			painel.add(getTextPosicao());
			painel.add(getLabelNum_camisa());
			painel.add(getTextNum_camisa());
			painel.add(getLabelClubes());
			painel.add(getComboBoxClubes());
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
	
	private JLabel getLabelApelido() {
		
		if (labelApelido == null) {
			labelApelido = new JLabel("Apelido: ");
			labelApelido.setBounds(10, 70, 80, 25);
		}
		return labelApelido;
	}

	private JTextField getTextApelido() {		
		
		if (textApelido == null) {
			textApelido = new JTextField();
			textApelido.setBounds(100, 70, 200, 25);
		}
		return textApelido;
	}
	
	private JLabel getLabelAltura() {
		
		if (labelAltura == null) {
			labelAltura = new JLabel("Altura: ");
			labelAltura.setBounds(10, 100, 80, 25);
		}
		return labelAltura;
	}

	private JTextField getTextAltura() {		
		
		if (textAltura == null) {
			textAltura = new JTextField();
			textAltura.setBounds(100, 100, 120, 25);		
		}
		return textAltura;
	}	
	
	private JLabel getLabelPeso() {
		if (labelPeso == null) {
			labelPeso = new JLabel("Peso: ");
			labelPeso.setBounds(10, 130, 100, 25);
		}
		return labelPeso;
	}

	private JTextField getTextPeso() {
		if (textPeso == null) {
			textPeso = new JTextField();
			textPeso.setBounds(100, 130, 120, 25);
		}
		return textPeso;
	}
	
	private JLabel getLabelPosicao() {
		if (labelPosicao == null) {
			labelPosicao = new JLabel("Posição: ");
			labelPosicao.setBounds(10, 160, 100, 25);
		}
		return labelPosicao;
	}

	private JTextField getTextPosicao() {
		if (textPosicao == null) {
			textPosicao = new JTextField();
			textPosicao.setBounds(100, 160, 150, 25);
		}
		return textPosicao;
	}
	
	private JLabel getLabelNum_camisa() {
		if (labelNum_camisa == null) {
			labelNum_camisa = new JLabel("Número: ");
			labelNum_camisa.setBounds(10, 190, 100, 25);
		}
		return labelNum_camisa;
	}

	private JTextField getTextNum_camisa() {
		if (textNum_camisa == null) {
			textNum_camisa = new JTextField();
			textNum_camisa.setBounds(100, 190, 60, 25);
		}
		return textNum_camisa;
	}

	// criando a combo de cursos
	private JLabel getLabelClubes() {
		if (labelClubes == null) {
			labelClubes = new JLabel("Clubes: ");
			labelClubes.setBounds(10, 220, 80, 25);
		}
		return labelClubes;
	}

	private JComboBox<Clube> getComboBoxClubes() {
		if (comboBoxClubes == null) {
			comboBoxClubes = new JComboBox<Clube>();
			comboBoxClubes.setBounds(100, 220, 300, 25);
			JogadorControle jc = new JogadorControle();
			try {
				List<Clube> clubes = jc.listarClube();
				for (Clube c : clubes) {
					comboBoxClubes.addItem(c);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return comboBoxClubes;
	}
	
	private JButton getBotaoSalvar() {
		if(botaoSalvar == null){
			botaoSalvar = new JButton("Salvar");
			botaoSalvar.setToolTipText("clique aqui para salvar");
			botaoSalvar.setBounds(30, 250, 100, 25);
			botaoSalvar.addActionListener(getEventoBotoes());
		}
		return botaoSalvar;
	}
	
	private JButton getBotaoLimpar() {
		if(botaoLimpar == null){
			botaoLimpar = new JButton("Limpar");
			botaoLimpar.setToolTipText("clique aqui para limpar os campos");
			botaoLimpar.setBounds(160, 250, 100, 25);
			botaoLimpar.addActionListener(getEventoBotoes());
		}
		return botaoLimpar;
	}
	
	private EventoBotoes getEventoBotoes() {
		if (eventoBotoes ==  null) {
			eventoBotoes = new EventoBotoes();
		}		
		return eventoBotoes;
	}
	
	private class EventoBotoes implements ActionListener{		
		public void actionPerformed(ActionEvent evento) {			
			if(evento.getSource() == getBotaoSalvar()){
				salvar();
			}
			else if(evento.getSource() == getBotaoLimpar()) {
				limparCampos();
			}
		}		
	} 
	
	
	private void salvar() {
		Clube clube = (Clube) getComboBoxClubes().getSelectedItem();
		String nome = getTextNome().getText();
		String apelido = getTextApelido().getText();
		float altura = Float.parseFloat(getTextAltura().getText());
		float peso = Float.parseFloat(getTextPeso().getText());
		String posicao = getTextPosicao().getText();
		int num_camisa = Integer.parseInt(getTextNum_camisa().getText());
		
		try {
			JogadorControle controle = new JogadorControle();
			controle.adicionar(clube, nome, apelido, altura, peso, posicao, num_camisa);
			JOptionPane.showMessageDialog(null, "Sucesso ao gravar jogador", "Sucesso", 
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao gravar jogador", "Erro", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void limparCampos() {
		getTextNome().setText("");
		getTextApelido().setText("");
		getTextAltura().setText("");
		getTextPeso().setText("");
		getTextPosicao().setText("");
		getTextNum_camisa().setText("");
	}
}

