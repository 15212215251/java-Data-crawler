package galaxy.tec.poiData.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Statement statement = null;
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection("jdbc:postgresql://192.168.0.150:5432/postgresql", "user", "pwd");
		connection.setAutoCommit(false);
		
		
	}
	
	
	
}
