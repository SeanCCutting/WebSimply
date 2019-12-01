package admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class ServerSetup extends HttpServlet {

	ConfigReader ConfigLoader;
	
	public ServerSetup() {
		System.out.println("==========");
		System.out.println("Started ServerSetup");
		System.out.println("==========");
		
		ConfigLoader = new ConfigReader();
		
		ConfigLoader.loadConfig();
		System.out.println(Constants.DATABASE_SQL_URL);
		System.out.println(Constants.DATABASE_SQL_USER);
		System.out.println(Constants.TEST_INT);
	}
}
