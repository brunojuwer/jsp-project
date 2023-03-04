package connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnetionDB {
	
	private final static String DB_URL = "jdbc:postgresql://localhost:5433/postgres?autoReconnect=true";
	private final static String DB_USER = "postgres";
	private final static String DB_PASSWORD = "docker";
	private static Connection connection = null;
	
	static {
		connect();
	}
	
	public SingleConnetionDB() {
		connect();
	}

	public static Connection getConnection() {
		return connection;
	}

	private static void connect() {
		try {
			Class.forName("org.postgresql.Driver"); // carrega o driver de conexão
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			connection.setAutoCommit(false);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
