package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.dal.PersistenceManager;

public class App {

	public static void main(String[] args) {

		try (Connection cnx = PersistenceManager.getConnection();
				Statement st = cnx.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM contact")) {
			while (rs.next()) {
				System.out.println(rs.getString("id"));
			}
		} catch (SQLException e) {
			System.out.println("Attention : " + e.getMessage());
		}

	}
}
