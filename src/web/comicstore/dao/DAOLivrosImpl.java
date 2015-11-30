package web.comicstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.comicstore.conection.DataBaseConnection;
import web.comicstore.entidade.Livros;

public class DAOLivrosImpl implements DAOLivros{

	final String insertProduto = "INSERT INTO produto( nome, descricao, preco,estoque) values (?,?,?,?)";
	
	@Override
	public void inserir(Livros l) {
		try {
			Connection con =  DataBaseConnection.getConnection();

			PreparedStatement stm = con.prepareStatement( insertProduto );
			stm.setString(1, l.getNome());
			stm.setString(2, l.getDescricao());
			stm.setDouble(3, l.getPreco());
			stm.setInt(4, l.getEstoque());
			stm.executeUpdate();
			
			final String insert ="INSERT INTO Livro" +
			"(isbn, editora, autor) " +
			"values (?,?,?)";
			
			PreparedStatement stm1 = con.prepareStatement( insert );
			
			stm1.setString(1, l.getISBN());
			stm1.setString(2, l.getEditora());
			stm1.setString(3, l.getAutor());
			

			stm1.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}

	@Override
	public void atualizar(Livros l) {
		try {
			Connection con =  DataBaseConnection.getConnection();

			final String atualiza ="UPDATE Livros" +
					"nome = ?" +
					"descricao = ?" +
					"preco = ?" +
					"isbn = ?" +
					"autor = ?" +
					"editora = ?" +
					"estoque = ?"+
					" WHERE codigo = ?";

			PreparedStatement stm = con.prepareStatement( atualiza );
			
			stm.setString(1, l.getNome());
			stm.setString(2, l.getDescricao());
			stm.setDouble(3, l.getPreco());
			stm.setString(4, l.getISBN());
			stm.setString(5, l.getAutor());
			stm.setString(6, l.getEditora());
			stm.setInt(7, l.getEstoque());
			stm.setInt(8, l.getCodigo());
			
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

			final String delete  ="DELETE FROM cliente WHERE codigo =(?)";

			PreparedStatement stm = con.prepareStatement( delete );
			stm.setLong(1, codigo );
			
			stm.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Livros> pesquisarPorNome(String nome) {
		List<Livros> lista = new ArrayList<Livros>();
		Connection con = DataBaseConnection.getConnection();
		String qry = "select * from produto where nome like ?";
		try {
			PreparedStatement stm = con.prepareStatement( qry );
			stm.setString(1, "%" + nome +"%");
			ResultSet rs = stm.executeQuery();
			while( rs.next() ){
				Livros l = new Livros();
				l.setCodigo(Integer.parseInt( rs.getString( "codigo" )));
				l.setNome( rs.getString( "nome" ));
				l.setDescricao( rs.getString( "descricao" ));
				l.setPreco(Double.parseDouble( rs.getString( "preco" )));
				lista.add( l );
				//System.out.println("codigo: "+l.getCodigo()+" Nome: "+l.getNome()+" Descrição: "+ l.getDescricao()+" Preço: "+l.getPreco());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return lista;
	}

	

	@Override
	public List<Livros> pesquisarPorISBN(String isbn) {
		List<Livros> lista = new ArrayList<Livros>();
		Connection con = DataBaseConnection.getConnection();
		String qry = "SELECT * FROM Livros" +
					 "WHERE isbn like ?";
		try {
			PreparedStatement stm = con.prepareStatement( qry );
			stm.setString(1, isbn );
			ResultSet rs = stm.executeQuery();
			while( rs.next() ){
				Livros l = new Livros();
				l.setCodigo(Integer.parseInt( rs.getString( "codigo" )));
				l.setNome( rs.getString( "nome" ));
				l.setDescricao( rs.getString( "descricao" ));
				l.setPreco(Double.parseDouble( rs.getString( "preco" )));
				l.setISBN( rs.getString( "isbn" ));
				l.setAutor( rs.getString( "autor" ));
				l.setEditora( rs.getString( "editora" ));
				l.setEstoque(rs.getInt("estoque"));
				lista.add( l );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return lista;
	}
}
