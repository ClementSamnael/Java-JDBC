package intro;

import java.sql.*;

public class AppJava {

	public static void main(String[] args) throws SQLException {

		System.out.println("Hello World !");
		String url = "jdbc:mysql://localhost:3306/book?useSSl=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String pwd = "";
		Connection connection = DriverManager.getConnection(url, login, pwd);
		
		try {

		} catch (Exception e) {

		} finally {

		}
	}
}
