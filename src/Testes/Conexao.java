package Testes;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao implements Serializable {

	
	
	/*
	 *  é igual a sua DataBaseConnection , só vi depois que ela estava ali 
	 */
	private static final long serialVersionUID = 4338567378340678479L;
	private Connection con;

	public Connection getConnection() {

		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=comicstore;namedPipe=true", "root", "30051994");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void fechaConexao() {
		try {
			if (con != null)
				con.close();
			con = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
