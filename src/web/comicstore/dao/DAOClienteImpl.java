package web.comicstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import web.comicstore.conection.DataBaseConnection;
import web.comicstore.entidade.Cliente;

public class DAOClienteImpl implements DAOCliente{

	Connection con ;

	
	

	
	
	
	@Override
	public void inserir(Cliente c) {
		Connection con =  DataBaseConnection.getConnection();
		String insert ="INSERT INTO cliente" +
				"(cpf, nome, nascimento, endereco, complemento, telefone) " +
				"values (?,?,?,?,?,?)";
		try {


			PreparedStatement stm = con.prepareStatement( insert );
			stm.setString(1, c.getCpf());
			stm.setString(2, c.getNome());
			stm.setDate(3, new java.sql.Date( c.getNascimento().getTime()));
			stm.setString(4, c.getEndereco());
			stm.setString(5, c.getComplemento());
			stm.setString(6, c.getTelefone());
			
			stm.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
		
	}

	@Override
	public void atualizar(String  cpf, Cliente c) {
		try {
			Connection con =  DataBaseConnection.getConnection();

			final String atualiza ="UPDATE cliente SET nome=?, nascimento=?, endereco=?,complemento=?, telefone=? WHERE cpf=?;";
			PreparedStatement stm = con.prepareStatement( atualiza );
			stm.setString(1, c.getNome());
			stm.setDate(2, new java.sql.Date( c.getNascimento().getTime()));
			stm.setString(3, c.getEndereco());
			stm.setString(4, c.getComplemento());
			stm.setString(5, c.getTelefone());
			stm.setString(6, c.getCpf());
			System.out.println("Updatado");
			JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
			stm.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void remover(String cpf) {
		
		try {
			Connection con =  DataBaseConnection.getConnection();

			final String delete  ="DELETE FROM cliente WHERE cpf =(?)";

			PreparedStatement stm = con.prepareStatement( delete );
			stm.setString(1, cpf );
			
			stm.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Cliente> pesquisarPorNome(String nome) {
		List<Cliente> lista = new ArrayList<Cliente>();
		Connection con = DataBaseConnection.getConnection();
		String qry="Select * from cliente where nome like ?";
		
		try {
			PreparedStatement stm = con.prepareStatement( qry );
			stm.setString(1, "%" + nome +"%");
			ResultSet rs = stm.executeQuery();
			while( rs.next() ){
				Cliente c = new Cliente();
				c.setCpf( rs.getString( "cpf") );
				c.setNome( rs.getString( "nome" ));
				c.setNascimento( rs.getDate( "nascimento" ));
				c.setEndereco( rs.getString( "endereco" ));
				c.setComplemento(rs.getString("complemento"));
				c.setTelefone( rs.getString( "telefone" ));
				lista.add( c );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return lista;
	}

	
	public List<Cliente> pesquisarPorCpf(String cpf) {
		List<Cliente> lista = new ArrayList<Cliente>();
		Connection con = DataBaseConnection.getConnection();
		String qry="Select * from cliente where cpf like ?";
		
		try {
			PreparedStatement stm = con.prepareStatement( qry );
			stm.setString(1, cpf);
			ResultSet rs = stm.executeQuery();
			while( rs.next() ){
				Cliente c = new Cliente();
				c.setCpf( rs.getString( "cpf") );
				c.setNome( rs.getString( "nome" ));
				c.setNascimento( rs.getDate( "nascimento" ));
				c.setEndereco( rs.getString( "endereco" ));
				c.setComplemento(rs.getString("complemento"));
				c.setTelefone( rs.getString( "telefone" ));
				lista.add( c );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return lista;
	}
	
	public Cliente pesquisarEditarCliente(String cpf){
		Connection con = DataBaseConnection.getConnection();
		Cliente c = new Cliente();
		String qry = "select * from cliente where cpf like ?";
		PreparedStatement st;
		try {
			st = con.prepareStatement(qry);
			st.setString(1, cpf);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				
				 c.setCpf(rs.getString("cpf"));
				 c.setNome(rs.getString("nome"));
				 c.setNascimento(rs.getDate("nascimento")); 
				 c.setEndereco(rs.getString("endereco"));
				 c.setComplemento(rs.getString("complemento"));
				 c.setTelefone(rs.getString("telefone"));
				 
			}
			
				
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERRO SQL");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERRO");
		}
		
		System.out.println("Tabela funcionario foi consultada com sucesso!");
		return c;
		
		
	}


}