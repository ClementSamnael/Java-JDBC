package dao.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.domain.Address;

public class AddressDAO {

	private static final String INSERT_QUERY_ADDRESS = "INSERT INTO address (details) VALUES (?)";
	private static final String UPDATE_QUERY_ADDRESS = "UPDATE address SET (details=?) WHERE id=?";
	private static final String DELETE_QUERY_ADDRESS = "DELETE FROM address WHERE id=?";

	public void createAddress(Address a) throws SQLException {

		Connection connection = PersistenceManager.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY_ADDRESS,
				Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, a.getDetails());
			ps.executeUpdate();
			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {
					a.setId(rs.getLong(1));
				}
			}
		}
	}

	public void updateAddress(Address a) throws SQLException {

		Connection connection = PersistenceManager.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY_ADDRESS,
				Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, a.getDetails());
			ps.setLong(2, a.getId());
			ps.executeUpdate();
			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {
					a.setId(rs.getLong(1));
				}
			}
		}
	}

	public void deleteAddress(Address a) throws SQLException {

		Connection connection = PersistenceManager.getConnection();

		try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY_ADDRESS,
				Statement.RETURN_GENERATED_KEYS)) {

			ps.setLong(1, a.getId());

			ps.executeUpdate();
		}
	}
}
