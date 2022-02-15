package controle;

import modelo.Clube;
import java.sql.SQLException;
import DAO.ClubeDAO;
import java.util.List;

public class ClubeControle {

	public void salvarClube(String nome, int titulos, String cidade, String tecnico) throws SQLException{
		Clube clube = new Clube();
		clube.setNome(nome);
		clube.setTitulos(titulos);
		clube.setCidade(cidade);
		clube.setTecnico(tecnico);

		ClubeDAO dao = new ClubeDAO();
		dao.adicionar(clube);
	}

	/*

	public void alterarClube(Long id, String nome, int titulos, String cidade, String tecncico) throws SQLException{
		Clube clube = new Clube();
		clube.setNome(nome);
		clube.setTitulos(titulos);
		clube.setCidade(cidade);
		clube.setTecnico(tecnico);
		clube.setId(id);

		ClubeDAO dao = new ClubeDAO();
		dao.alterar(clube);
	}	

	public void removerClube(Long id) throws SQLException{
		Clube clube = new Clube();
		clube.setId(id);

		ClubeDAO dao = new ClubeDAO();
		dao.remover(clube);
	}	
	
	public List<Clube> listarClube() throws SQLException{
		ClubeDAO dao = new ClubeDAO();
		return dao.listarClube();
	}

	*/

}