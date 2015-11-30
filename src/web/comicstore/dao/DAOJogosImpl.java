package web.comicstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.comicstore.conection.DataBaseConnection;
import web.comicstore.entidade.Jogos;

public class DAOJogosImpl implements DAOJogos{

	final String pesqPorCodigo = "SELECT * FROM Jogos WHERE codigo like ?";
	final String pesqPorGenero = "Select * from Jogos Where genero like ?";
	final String pesqPorNome = "SELECT * FROM produto where nome like ?";
	final String delete  ="DELETE FROM cliente WHERE codigo =(?)";
	final String atualiza ="UPDATE Jogos nome = ? descricao = ? preco = ? distribuidora = ? genero = ? WHERE id = ?";
	final String insertProduto = "INSERT INTO produto( nome, descricao, preco,estoque) values (?,?,?,?)";
	

	@Override
	public void inserir(Jogos j) {
		try {
			Connection con =  DataBaseConnection.getConnection();			
			
			PreparedStatement stm = con.prepareStatement( insertProduto );
			stm.setString(1, j.getNome());
			stm.setString(2, j.getDescricao());
			stm.setDouble(3, j.getPreco());
			stm.setInt(4, j.getEstoque());
			
			final String insert ="INSERT INTO Jogos" +
			"(distribuidora, genero) " +
			"values (?,?)";
			
			PreparedStatement stm1 = con.prepareStatement( insert );
			
			stm1.setString(1, j.getDistribuidora());
			stm1.setString(2, j.getGenero());
			
			stm.executeUpdate();
			stm1.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}

	@Override
	public void atualizar(Jogos j) {
		try {
			Connection con =  DataBaseConnection.getConnection();

			PreparedStatement stm = con.prepareStatement( atualiza );
			stm.setInt(5, j.getCodigo());
			stm.setString(1, j.getNome());
			stm.setString(2, j.getDescricao());
			stm.setDouble(3, j.getPreco());
			stm.setString(4, j.getDistribuidora());
			
			stm.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void remover(int codigo) {
		
		try {
			Connection con =  DataBaseConnection.getConnection();

			PreparedStatement stm = con.prepareStatement( delete );
			stm.setLong(1, codigo );
			
			stm.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Jogos> pesquisarPorNome(String nome) {
		List<Jogos> lista = new ArrayList<Jogos>();
		Connection con = DataBaseConnection.getConnection();
		
		try {
			PreparedStatement stm = con.prepareStatement( pesqPorNome );
			stm.setString(1, "%" + nome +"%");
			ResultSet rs = stm.executeQuery();
			while( rs.next() ){
				Jogos j = new Jogos();
				j.setCodigo( rs.getInt( "codigo" ));
				j.setNome( rs.getString( "nome" ));
				j.setDescricao( rs.getString( "descricao" ));
				j.setPreco(Double.parseDouble( rs.getString( "preco" )));
				j.setEstoque(rs.getInt("estoque"));
				lista.add( j );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return lista;
	}

	

	@Override
	public List<Jogos> pesquisarPorDistribuidora(String distribuidora) {
		List<Jogos> lista = new ArrayList<Jogos>();
		Connection con = DataBaseConnection.getConnection();
		String qry = "SELECT * FROM Jogos" +
					 "WHERE distribuidora like ?";
		try {
			PreparedStatement stm = con.prepareStatement( qry );
			stm.setString(1, distribuidora );
			ResultSet rs = stm.executeQuery();
			while( rs.next() ){
				Jogos j = new Jogos();
				j.setCodigo( rs.getInt( "id" ));
				j.setNome( rs.getString( "nome" ));
				j.setDescricao( rs.getString( "descricao" ));
				j.setPreco(Double.parseDouble( rs.getString( "preco" )));
				j.setDistribuidora( rs.getString( "distribuidora" ));
				j.setEstoque(rs.getInt("estoque"));
				lista.add( j );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return lista;
	}
	
	
	@Override
	public List<Jogos> pesquisarPorGenero(String genero) {
		List<Jogos> lista = new ArrayList<Jogos>();
		Connection con = DataBaseConnection.getConnection();
		
		try {
			PreparedStatement stm = con.prepareStatement( pesqPorNome );
			stm.setString(1, "%" + genero +"%");
			ResultSet rs = stm.executeQuery();
			while( rs.next() ){
				Jogos j = new Jogos();
				j.setCodigo( rs.getInt( "id" ));
				j.setNome( rs.getString( "nome" ));
				j.setDescricao( rs.getString( "descricao" ));
			//	j.setDistribuidora( rs.getString( "distribuidora" ));
				//j.setGenero(rs.getString("genero"));
				//j.setEstoque(rs.getInt("estoque"));
				lista.add( j );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return lista;
	}
	
}
