package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class User {
	public String login(String userN, String passw) {
		
		Connection con = null;
		Statement statement = null;
		ResultSet resulSet = null;
		
		String userNameDB = "";
		String passwordDB = "";
		
		try {
			
			con = (Connection) DBConnection.createConnection();
			statement = (Statement) con.createStatement();
			resulSet = statement.executeQuery("select nameUsere, passuser");
			
				while(resulSet.next()) {
					userNameDB = resulSet.getString("nameUsers");
					passwordDB = resulSet.getString("passUsers");
					
					if(userN.equals(userNameDB)&&passw.equals(passwordDB)) {
						return "SUCCESS";
					}
				}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	return "invalid user credentials..";	
	}

}
