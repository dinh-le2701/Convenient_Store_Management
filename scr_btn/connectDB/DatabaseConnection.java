package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public static Connection con = null;
	private static DatabaseConnection instance = new DatabaseConnection();
	
	public static DatabaseConnection getInstance() {
		return instance;
	}
	
	public void connect() throws Exception {
		String username = "sa";
		String password = "1";
				
		String url = "jdbc:sqlserver://localhost:1434;databasename=QL_CHTL";
		con = DriverManager.getConnection(url, username, password);
	}
	
	public void disconnect() {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
}

