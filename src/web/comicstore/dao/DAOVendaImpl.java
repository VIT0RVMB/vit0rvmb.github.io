package web.comicstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import web.comicstore.conection.DataBaseConnection;
import web.comicstore.entidade.Produto_Carrinho;

public class DAOVendaImpl {

	public void salvar(List<Produto_Carrinho> lista1, String text,
			double parseDouble) {
		Connection con =  DataBaseConnection.getConnection(); 
		final String insert ="INSERT INTO venda" +
				"(cpf, nome, quantidade, precoFinal) " +
				"values (?,?,?,?)";
		try {
			PreparedStatement stm = con.prepareStatement( insert );
			
			
			for(Produto_Carrinho p: lista1){
				stm.setString(1, text);
				stm.setDouble(4, parseDouble);
				stm.setString(2, p.getNome());
				stm.setDouble(3,p.getQuantidade());
				stm.execute();
			}


		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}

}
