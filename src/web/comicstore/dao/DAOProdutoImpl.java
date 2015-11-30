package web.comicstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.comicstore.conection.DataBaseConnection;
import web.comicstore.entidade.Produto;

public class DAOProdutoImpl implements DAOProduto {

	@Override
	public void inserir(Produto j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Produto j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produto> pesquisarPorNome(String nome) {
			List<Produto> lista = new ArrayList<Produto>();
			Connection con = DataBaseConnection.getConnection();
			String qry="select * from produto where nome like ?";
			
			try {
				PreparedStatement stm = con.prepareStatement( qry );
				stm.setString(1, "%" + nome +"%");
				ResultSet rs = stm.executeQuery();
				while( rs.next() ){
					Produto p = new Produto();
					p.setCodigo(rs.getInt("id"));
					p.setNome( rs.getString( "nome" ));
					p.setDescricao(rs.getString("descricao"));
					p.setPreco(rs.getDouble("preco"));
					//p.setEstoque(rs.getInt("estoque"));
					lista.add( p );
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			return lista;
		
	}

}
