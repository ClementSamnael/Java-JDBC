package dao.dal;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//Class pour les connections
public class PersistenceManager {

	private static final int CHECK_CONNECTION_TIMEOUT = 10;
	private static Connection connection;

	private PersistenceManager() {
	}

	public static Connection getConnection() throws SQLException {
		if (null == connection || connection.isClosed() || !connection.isValid(CHECK_CONNECTION_TIMEOUT)) {

			Properties props = new Properties();
			try (FileInputStream fis = new FileInputStream("src/main/resources/conf.properties")) {
				props.load(fis);
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			String url = props.getProperty("ds.jdbc.url");
			String login = props.getProperty("ds.user.login");
			String pwd = props.getProperty("ds.user.pwd");
			connection = DriverManager.getConnection(url, login, pwd);
		}
		return connection;
	}

	// Si traitement alternatif => on fait la levée des Exception avec throw
	public static void closeConnection() throws SQLException {
		if (null != connection && !connection.isClosed()) {
			connection.close();
		}
	}

}
