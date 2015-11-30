package web.comicstore.dao;

import java.sql.SQLException;
import web.comicstore.entidade.FuncionarioLogin;

public interface  DAOFuncionarioLogin {
	public void inserir( FuncionarioLogin fl )throws SQLException;
	public void atualizar( String userID, FuncionarioLogin fl);
	public void remover( String userID );
	public FuncionarioLogin pesquisar( String userID);
	public String validaLogin(FuncionarioLogin fl);
}
