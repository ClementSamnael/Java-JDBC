package injection;

import java.sql.*;

public class App {

	public static void main(String[] args) throws SQLException {
		System.out.println("Hello World !");
		// pour wamp : useLegacyDatetimeCode=false&serverTimezone=UTC
		String url = "jdbc:mysql://localhost:3306/book?useSSl=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String pwd = "";
		Connection connection = DriverManager.getConnection(url, login, pwd);
		Statement st = connection.createStatement();
		st.executeUpdate("INSERT INTO address (details) VALUES ('11 rue des Freres Lumieres')",
				Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = st.getGeneratedKeys();
		if (rs.next()) {
			st.executeUpdate(
					"INSERT INTO contact (email, first_name, last_name, address_id) VALUES ('test@gmail.com', 'Cl', 'Or', "
							+ rs.getLong(1) + ")");
		}
		rs.close();

		ResultSet rsSelect = st
				.executeQuery("SELECT * FROM contact INNER JOIN address ON contact.address_id = address.id");

		while (rsSelect.next()) {
			System.out.println(rsSelect.getString("email") + " " + rsSelect.getString("first_name") + " "
					+ rsSelect.getString("last_name") + " " + rsSelect.getString("details"));
		}

		rsSelect.close();
		st.close();
		connection.close();
	}

}
