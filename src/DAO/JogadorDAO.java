package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import modelo.*;

public class JogadorDAO {
	private Connection connection;

	public JogadorDAO() throws SQLException {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adicionar(Jogador jogador) throws SQLException {
		String sql = "insert into jogador (id_clube, nome, apelido, altura, peso, posicao, num_camisa) values (?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setLong(1, jogador.getClube().getId());
		stmt.setString(2, jogador.getNome());
		stmt.setString(3, jogador.getApelido());
		stmt.setFloat(4, jogador.getAltura());
		stmt.setFloat(5, jogador.getPeso());
		stmt.setString(6, jogador.getPosicao());
		stmt.setInt(7, jogador.getNum_camisa());
		stmt.execute();
		stmt.close();
	}
	
//	public void alterar(Jogador jogador) throws SQLException {
//		String sql = "update jogador set nome = ?, apelido = ?, altura = ?, peso = ?, posicao = ?, num_camisa = ? where id = ?;";
//		PreparedStatement stmt = this.connection.prepareStatement(sql);
//		stmt.setString(1, jogador.getNome());
//		stmt.setString(2, jogador.getApelido());
//		stmt.setFloat(3, jogador.getAltura());
//		stmt.setFloat(4, jogador.getPeso());
//		stmt.setString(5, jogador.getPosicao());
//		stmt.setInt(6, jogador.getNum_camisa());
//		stmt.setLong(7, jogador.getId());
//		stmt.execute();
//		stmt.close();
//	}
//	
//	public void apagar(Jogador jogador) throws SQLException {
//		String sql = "delete from jogador where id=?";
//		PreparedStatement stmt = this.connection.prepareStatement(sql);
//		stmt.setLong(1, jogador.getId());
//		stmt.execute();
//		stmt.close();
//	}
//	
	public List<Jogador> listarJogador() throws SQLException {
		List<Jogador> jogadores  = new ArrayList<Jogador>();
		
		String sql = "select * from jogador";
		Statement stmt = this.connection.createStatement();
		ResultSet resultadoBusca = stmt.executeQuery(sql);
		
		//id, nome, apelido, altura, peso, posicao, num_camisa
		while (resultadoBusca.next()) {			
			Long id_jogador = resultadoBusca.getLong("id");
			String nome = resultadoBusca.getString("nome");
			String apelido = resultadoBusca.getString("apelido");
			Float altura = resultadoBusca.getFloat("altura");
			Float peso = resultadoBusca.getFloat("peso");
			String posicao = resultadoBusca.getString("posicao");
			int num_camisa = resultadoBusca.getInt("num_camisa");
			Jogador jogador = new Jogador();
			jogador.setId(id_jogador);
			jogador.setNome(nome);
			jogador.setApelido(apelido);
			jogador.setAltura(altura);
			jogador.setPeso(peso);
			jogador.setPosicao(posicao);
			jogador.setNum_camisa(num_camisa);
		}
		
		stmt.close();
		return jogadores;
	}
	
	public Jogador getById(long id) throws SQLException{
		String sql = "select * from jogador where id = ?";
		Statement stmt = this.connection.createStatement();
		ResultSet resultadoBusca = stmt.executeQuery(sql);
		Jogador jogador = new Jogador();
		
		while (resultadoBusca.next()) {			
			Long id_jogador = resultadoBusca.getLong("id");
			String nome = resultadoBusca.getString("nome");
			String apelido = resultadoBusca.getString("apelido");
			Float altura = resultadoBusca.getFloat("altura");
			Float peso = resultadoBusca.getFloat("peso");
			String posicao = resultadoBusca.getString("posicao");
			int num_camisa = resultadoBusca.getInt("num_camisa");
			jogador.setId(id_jogador);
			jogador.setNome(nome);
			jogador.setApelido(apelido);
			jogador.setAltura(altura);
			jogador.setPeso(peso);
			jogador.setPosicao(posicao);
			jogador.setNum_camisa(num_camisa);
		}
		
		return jogador;
		
	}
}
