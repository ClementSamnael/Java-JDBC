package injection;

import java.sql.*;
import java.util.Scanner;

public class App {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		System.out.println("######### Boite de login ##########");
		// pour wamp : useLegacyDatetimeCode=false&serverTimezone=UTC
		String url = "jdbc:mysql://localhost:3306/book?useSSl=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String pwd = "";

		Connection connection = DriverManager.getConnection(url, login, pwd);
		Statement st = connection.createStatement();

		System.out.println("Entrez votre login : ");
		String loginUser = sc.nextLine();
		System.out.println("Entrez votre mot de passe : ");
		String pwdUSer = sc.nextLine();

		String query = "SELECT * FROM contact WHERE email = ? AND first_name = ?";

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, loginUser);
		ps.setString(2, pwdUSer);
		ResultSet rs = ps.executeQuery();

		System.out.println(query);
		System.out.println(ps);

		if (rs.next()) {
			System.out.println("Bienvenue dans votre espace de travail : " + rs.getString("first_name") + " "
					+ rs.getString("last_name"));
		} else {
			System.out.println("Erreur : login / mot de passe incorrect");
		}
		rs.close();
		st.close();
		connection.close();
	}

}
