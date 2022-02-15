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

public class ClubeDAO {
	
	private Connection connection;
	
	public ClubeDAO() throws SQLException {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public List<Clube> listarClube() throws SQLException{
		List<Clube> clubes = new ArrayList<Clube>();
		String sql = "SELECT * FROM clube;";
		Statement stmt = this.connection.createStatement();
		ResultSet resultadoBusca = stmt.executeQuery(sql);
		
		while (resultadoBusca.next()) {
			Long id_clube = resultadoBusca.getLong("id");
			String nome = resultadoBusca.getString("nome");
			int  titulos = resultadoBusca.getInt("titulos");
			String  cidade = resultadoBusca.getString("cidade");
			String  tecnico = resultadoBusca.getString("tecnico");
			Clube clube = new Clube();
			clube.setId(id_clube);
			clube.setNome(nome);
			clube.setTitulos(titulos);
			clube.setCidade(cidade);
			clube.setTecnico(tecnico);
			clubes.add(clube);
		}
		
		stmt.close();
		return clubes;
	}
	
//	public void remover(Clube clube) throws SQLException{
//		String sql= "DELETE FROM clube WHERE id = ?";
//		PreparedStatement stmt = this.connection.prepareStatement(sql);
//		stmt.setLong(1, clube.getId());
//		stmt.execute();
//		stmt.close(); 
//	}
//	
//	public void alterar(Clube clube) throws SQLException {
//		String sql= "UPDATE clube SET nome = ?, titulos = ?, cidade = ?, tecnico = ?  WHERE id = ?;";
//		PreparedStatement stmt = this.connection.prepareStatement(sql);
//		stmt.setString(1, clube.getNome());
//		stmt.setInt(2, clube.getTitulos());
//		stmt.setString(3, clube.getCidade());
//		stmt.setString(4, clube.getTecnico());
//		stmt.setLong(5, clube.getId());
//		stmt.execute();
//		stmt.close();
//	}
//	
	public void adicionar(Clube clube) throws SQLException {
		String sql = "INSERT INTO clube (nome, titulos, cidade, tecnico) VALUES (?,?,?,?);";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, clube.getNome());
		stmt.setInt(2, clube.getTitulos());
		stmt.setString(3, clube.getCidade());
		stmt.setString(4, clube.getTecnico());
		stmt.execute();
		stmt.close();
	}
	
//	public static Clube getById (long id_clube) throws SQLException {
//		String sql = "SELECT * FROM clube where id = ?;";
//		PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
//		stmt.setLong(1, id_clube); 
//		ResultSet resultadoBusca = stmt.executeQuery();
//		Clube clube = new Clube();
//		
//		while (resultadoBusca.next()) {
//			String nome = resultadoBusca.getString("nome");
//			int titulos = resultadoBusca.getInt("titulos");
//			String cidade = resultadoBusca.getString("cidade");
//			String tecnico = resultadoBusca.getString("tecnico");
//			clube.setId(id_clube);
//			clube.setNome(nome);
//			clube.setTitulos(titulos);
//			clube.setCidade(cidade);
//			clube.setTecnico(tecnico);
//
//	    }
//		return clube;
//	}
}
