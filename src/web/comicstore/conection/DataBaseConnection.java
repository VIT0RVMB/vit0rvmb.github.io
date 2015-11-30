package web.comicstore.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	
	private static Connection con;
	
	public static Connection getConnection(){
		try {
			if(con == null){
				Class.forName("com.mysql.jdbc.Driver");
			}			
			try {
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/comicstore","root","30051994");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;		
	}
	
}
