package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Item {
	
	public String getItems() {
	
		String itemsGrid = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			con = (Connection) DBConnection.createConnection();
			st = (Statement) con.createStatement();
			rs = st.executeQuery("select * from items");
			
			if(rs.first())
			{
				itemsGrid = "<table border = '1' cellspacing='1' cellpadding='1'><tr><th>no</th>"
						+ "<th>Name</th><th>Description</th><th>Edit</th><th>Delete</th></tr>";				
								
					rs.beforeFirst();
			while(rs.next())
			{
				itemsGrid = itemsGrid + "<tr><td>" + rs.getString(1) + "</td>"
						+ "<td>" + rs.getString(2) + "</td>"
						+ "<td>" + rs.getString(3) + "</td>"
						+ "<td><input id=\"btnEdit\" type=\"button\" name=\"btnEdit\" param=\""
						+ rs.getString(1) + "\" value=\"Edit\"</td>"
						+ "<td>" + "<input id=\"btnRemove\" type=\"button\" name=\"btnRemove\" param=\""
						+ rs.getString(1) + "\" value=\"Remove\"</td></tr>";
					
				
		}
			}
			else
				itemsGrid = "there are no items..";
			itemsGrid = itemsGrid + "</table></br>";
			
		}catch (SQLException e) {
		e.printStackTrace();	
		}
		
		return itemsGrid;
		
		}
		public String saveAnItem(String itmName, String itmDesc) {
			
				String res = null;
				String sql =null;
				Connection con = null;
				Statement st = null;
				
				try {
					con = (Connection) DBConnection.createConnection();
					st = (Statement) con.createStatement();
					sql = "insert into items(nameitems, descitems) values"
							+ "('"+ itmName +"','"+ itmDesc +"')";
							st.executeUpdate(sql);
							res = "successfully inserted..";
						}
						catch (SQLException e) {
							e.printStackTrace();
						}
		
		return res;
	}
		public CharSequence updateItem(String string, String string2, String string3) {
			// TODO Auto-generated method stub
			return null;
		}
		public CharSequence deleteItem(String string) {
			// TODO Auto-generated method stub
			return null;
		}
		
}
