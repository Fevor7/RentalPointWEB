package by.htp.sportequip.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public abstract class ConnectionDataBase {
	
	public static Connection connectDataBase(){
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String dbUrl = rb.getString("db.url");
		String dbUser = rb.getString("db.login");
		String dbPass = rb.getString("db.pas");
		String driverName = rb.getString("db.driver.name");
		Connection conn = null;
		try {
			 Class.forName(driverName);
			 conn = DriverManager.getConnection(dbUrl, dbUser,dbPass);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs){
		try { conn.close(); } catch(SQLException se) { se.printStackTrace();}
		try { ps.close(); } catch(SQLException se) {se.printStackTrace();}
        try { rs.close(); } catch(SQLException se) {se.printStackTrace();}
	}
	
	public static void closeConnection(Connection conn, PreparedStatement ps){
		try { conn.close(); } catch(SQLException se) { se.printStackTrace();}
		try { ps.close(); } catch(SQLException se) {se.printStackTrace();}
	}

}
