package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connections.SingleConnetionDB;
import models.Login;

public class DAOLoginRepository {
	
	private Connection conn;
 
	public DAOLoginRepository() {
		this.conn = SingleConnetionDB.getConnection();
	}
	
	public boolean validateAuthentication(Login login) {
		try {
			String sql = "SELECT * FROM login WHERE username = ? AND password = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, login.getUsername());
			statement.setString(2, login.getPassword());
			
			ResultSet resulSet = statement.executeQuery();
			
			
			if(resulSet.next()) {
				return true;
			}
			
			return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	

}
