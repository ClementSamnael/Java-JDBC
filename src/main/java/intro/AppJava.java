package intro;

import java.sql.*;

public class AppJava {

	public static void main(String[] args) throws SQLException {

		System.out.println("Hello World !");
		// pour wamp : useLegacyDatetimeCode=false&serverTimezone=UTC
		String url = "jdbc:mysql://localhost:3306/book?useSSl=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String pwd = "";
		Connection connection = DriverManager.getConnection(url, login, pwd);
		Statement st = connection.createStatement();		
		
		st.executeUpdate("INSERT INTO contact (email,first_name,last_name,address_id) VALUES ('co@gmail.com', 'Clement', 'Ormaux', 1)");
		
		
		st.close();
		connection.close();
	}
}
