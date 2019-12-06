package admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import util.DatabaseUtil;

@SuppressWarnings("serial")
public class ServerSetup extends HttpServlet {

	ConfigReader configLoader;
	DatabaseUtil database;
	
	public ServerSetup() {
		System.out.println("==========");
		System.out.println("Started ServerSetup");
		System.out.println("==========");
		
		configLoader = new ConfigReader();
		database = new DatabaseUtil();
		configLoader.loadConfig();
		database.initDatabase();
		
		System.out.println(WebConstants.DATABASE_SQL_URL);
		System.out.println(WebConstants.DATABASE_SQL_USER);
		System.out.println(WebConstants.TEST_INT);
	}
}
