package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {
	//認證
	 private static String urlToBanana ="jdbc:sqlserver://localhost:1433;databaseName=banana;encrypt=false";
	 private static String urlToconnecturl ="jdbc:sqlserver://localhost:1433;databaseName=connecturl;encrypt=false";
	 private static String user ="AJ";
	 private static String pwd ="1234";
	
	//連接database
	 static Connection conn =null;
	
	public static  Connection getConnectionToDB() {
		
		try {
			free();
			return conn = DriverManager.getConnection(urlToBanana,user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}return conn;
	}
	public static  Connection getConnectionTokindergarten() {
			
			try {
				free();
				return conn = DriverManager.getConnection(urlToconnecturl,user, pwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}return conn;
		}
	
	public static boolean free() {
		try {
			if(conn==null || conn.isClosed()) return true;
			conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
