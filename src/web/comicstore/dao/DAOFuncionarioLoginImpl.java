package web.comicstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.comicstore.conection.DataBaseConnection;
import web.comicstore.entidade.FuncionarioLogin;

public class DAOFuncionarioLoginImpl implements DAOFuncionarioLogin {

	
Connection con ;
	
	public DAOFuncionarioLoginImpl() {
		
		con = DataBaseConnection.getConnection();	

	}
	
	
	@Override
	public void inserir(FuncionarioLogin fl) throws SQLException {

		String qry ="INSERT into funcionariologin (userid, senha) values(?,?)";
	
			PreparedStatement stm = con.prepareStatement(qry);
			stm.setString(1, fl.getUserID());
			stm.setString(2,fl.getSenha());
			stm.executeUpdate();
			con.close();
	
			stm.execute();
			stm.close();
	}

	@Override
	public void atualizar(String userID, FuncionarioLogin fl) {
		
		
	}

	@Override
	public void remover(String userID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FuncionarioLogin pesquisar(String userID) {
		// TODO Auto-generated method stub
		FuncionarioLogin fl=new FuncionarioLogin();
		Connection con = DataBaseConnection.getConnection();
		String qry="Select * from funcionariologin where userid like ?";
		try {
			PreparedStatement stm = con.prepareStatement(qry);
			stm.setString(1, userID);
			ResultSet rs=stm.executeQuery();
			
			if(stm.equals(null)){
				System.out.println("Usuario não encontrado");
			}else{
				while(rs.next()){
					fl.setUserID(rs.getString("userid"));
					fl.setSenha(rs.getString("senha"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fl;
	}
	
	public String validaLogin(FuncionarioLogin fl) {
		String status=null;
		FuncionarioLogin fl1 = new FuncionarioLogin();
		try{
			fl1=pesquisar(fl.getUserID());
			if(fl1.getSenha().equals(fl.getSenha())){
				
				System.out.println("LOGIN REALIZADO");
				System.out.println("Senha Correta: "+fl1.getSenha()+"Digitada: "+fl.getSenha());
				status="/teste";
			}else{
				System.out.println("Senha Incorreta");
				System.out.println("Senha Correta: "+fl1.getSenha()+"Digitada: "+fl.getSenha());
				status="/index";
			}
		}catch(NullPointerException e){
			System.out.println("Usuário Não encontrado");
		}
			
		
		/*if(getUserID().equals("vmborges")&&getSenha().equalsIgnoreCase("30051994")){
			status="\teste";
		}*/
		return status;
	}
	
	
}
