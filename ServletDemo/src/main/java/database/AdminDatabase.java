package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDatabase {

	//--------------------------------------------------------------------------------
	public boolean validateAdmin(String username, String password) throws SQLException
	{
		boolean isValidAdmin = false;
		String sql = "SELECT * FROM learnersacademy.admins WHERE admin_username=?";
		
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		PreparedStatement stat = conn.prepareStatement(sql); //2. Create the statement
		stat.setString(1, username);
		ResultSet rs = stat.executeQuery(); //3. Execute the query
		
		if (rs.next()) {
			String pass = rs.getString(2);
			if (pass.contentEquals(password)) isValidAdmin = true;
		}
		System.out.println("isValidAdmin =" + isValidAdmin);
		
		return isValidAdmin;
	}
	
}
