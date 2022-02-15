package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() throws SQLException {
    	try {
    		return DriverManager.getConnection("jdbc:postgresql://localhost/P2LP", 
    				"postgres", "password");
    	} catch (SQLException e) {
    		throw new SQLException(e.getMessage());
    	}
	}

}
