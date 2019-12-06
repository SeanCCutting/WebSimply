package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import admin.WebConstants;

public class DatabaseUtil {
	
	static DataSource datasource;
	
	public void initDatabase() {
		try {
			PoolProperties p = new PoolProperties();
	        p.setUrl(WebConstants.DATABASE_SQL_URL);
	        p.setDriverClassName("com.mysql.jdbc.Driver");
	        p.setUsername("root");
	        p.setPassword("centric");
	        datasource = new DataSource();
	        datasource.setPoolProperties(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static boolean validateLogin(String l_Username, String l_Password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "";
		ResultSet rs = null;
		Boolean validLogin = false;
		
		try {
			conn = datasource.getConnection();
			//conn = DriverManager.getConnection(WebConstants.DATABASE_SQL_URL, WebConstants.DATABASE_SQL_USER, WebConstants.DATABASE_SQL_PASS);
			
			sql = "SELECT * FROM useraccounts WHERE Username=? AND Password=?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, l_Username);
			stmt.setString(2, l_Password);
			
			rs = stmt.executeQuery();
			validLogin = rs.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return validLogin;
	}
}
