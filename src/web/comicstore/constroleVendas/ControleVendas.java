package web.comicstore.constroleVendas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.comicstore.conection.DataBaseConnection;
import web.comicstore.entidade.Produto;

public class ControleVendas {
	
	
	public Produto realizaPesquisaCarrinho(String nome){
		Produto p = new Produto();
		List<Produto> lista = new ArrayList<Produto>();
		Connection con = DataBaseConnection.getConnection();
		String qry="Select * from produto where nome like ?";
		PreparedStatement stm;
		try {
			stm = con.prepareStatement( qry );
			
			stm.setString(1, "%" + nome +"%");
			ResultSet rs = stm.executeQuery();
			while( rs.next() ){
				
				p.setCodigo(rs.getInt("id"));
				p.setNome( rs.getString( "nome" ));
				p.setDescricao(rs.getString("descricao"));
				p.setPreco(rs.getDouble("preco"));
				//p.setEstoque(rs.getInt("estoque"));
				lista.add( p );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	public int recebeQuantidade(int quant){
		return quant;
	}
}
