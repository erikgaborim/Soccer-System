package controle;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import DAO.*;
import modelo.*;

public class JogadorControle {
	public List<Clube> listarClube() throws SQLException{
		ClubeDAO dao = new ClubeDAO();
		return dao.listarClube();
	}
	
	//id, nome, apelido, altura, peso, posicao, num_camisa
	public void adicionar(Clube clube, String nome, String apelido, Float altura, Float peso, String posicao, int num_camisa) throws SQLException {
		Jogador jogador = new Jogador();
		jogador.setNome(nome);
		jogador.setApelido(apelido);
		jogador.setAltura(altura);
		jogador.setPeso(peso);
		jogador.setPosicao(posicao);
		jogador.setNum_camisa(num_camisa);		
		jogador.setClube(clube);
		
		JogadorDAO jogadorDAO = new JogadorDAO();
		jogadorDAO.adicionar(jogador);
	}
}
