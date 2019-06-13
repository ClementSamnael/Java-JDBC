package dao.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import dao.domain.Address;

public class AddressDAO {

	private static final String INSERT_QUERY_ADDRESS = "INSERT INTO address (details) VALUEs (?)";

	public void createAddress(Address a) throws SQLException {

		Connection connection = PersistenceManager.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY_ADDRESS,
				Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, a.getDetails());
		} catch (SQLException e) {
		}
	}

}
