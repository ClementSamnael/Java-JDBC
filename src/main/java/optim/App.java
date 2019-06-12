package optim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/book?useSSl=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String pwd = "";

		try (Connection cnx = DriverManager.getConnection(url, login, pwd);
				Statement st = cnx.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM contact")) {
			while (rs.next()) {

			}
		} catch (SQLException e) {
		}
	}
}
