package metadata;

import java.sql.*;
import java.util.Scanner;

public class App {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/book?useSSl=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String pwd = "";
		Connection connection = DriverManager.getConnection(url, login, pwd);

		DatabaseMetaData metaData = connection.getMetaData();
		// getTables(catalog, schemaPattern, tableNamePattern, types)
		ResultSet rs = metaData.getTables(connection.getCatalog(), null, "", null);
		System.out.println("Liste des tables de la BDD book : ");
		while (rs.next()) {
			System.out.print(rs.getString("TABLE_NAME") + " - ");
		}

		System.out.println();
		String response;
		// String query = "SELECT * FROM ?";
		Statement st = connection.createStatement();

		do {
			System.out.print("Entrez le nom de la table : ");
			response = sc.nextLine();
			if (!response.equals("exit")) {
				ResultSet resultSet = st.executeQuery("SELECT * FROM " + response);
				ResultSetMetaData rsMetaData = resultSet.getMetaData();
				int count = rsMetaData.getColumnCount();
				if (count > 0) {
					System.out.println("Voici les infos de la table : " + response);
					System.out.println();
					for (int i = 1; i <= count; ++i) {
						System.out.printf("%-20s",
								rsMetaData.getColumnLabel(i) + "[" + rsMetaData.getColumnTypeName(i) + "]");
					}
					System.out.println();
					System.out.println(
							"======================================================================================================================");
					while (resultSet.next()) {
						for (int i = 1; i <= count; ++i) {
							System.out.printf("%-20s", resultSet.getString(i));
						}
						System.out.println();
						System.out.println();
					}
				}
				resultSet.close();
			}
		} while (!response.equals("exit"));
		st.close();
		rs.close();
		connection.close();
	}

}
