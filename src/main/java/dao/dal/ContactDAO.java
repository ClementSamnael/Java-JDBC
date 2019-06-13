package dao.dal;

import static java.sql.Types.BIGINT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.domain.Address;
import dao.domain.Contact;

//requetes SQL de la table contact dans cette classe
public class ContactDAO {

	private static final String INSERT_QUERY = "INSERT INTO contact (email, first_name, last_name, address_id) VALUES (?,?,?,?)";
	private static final String UPDATE_QUERY = "UPDATE contact SET (email=?, first_name=?, last_name=?, address_id=?) WHERE id=?";
	private static final String DELETE_QUERY = "DELETE FROM contact WHERE id=?";
	private static final String SELECT_QUERY = "SELECT * FROM contact WHERE id=?";

	public void createContact(Contact c) throws SQLException {

		Connection connection = PersistenceManager.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, c.getEmail());
			ps.setString(2, c.getFirstName());
			ps.setString(3, c.getLastName());
			Address address = c.getAddress();

			if (null != address) {
				if (null == address.getId()) {
					// daoAddress.create(address);
					// TODO créer l'adresse pour pouvoir l'associer au contact
					AddressDAO addressDAO = new AddressDAO();
					addressDAO.createAddress(address);
				}
				ps.setLong(4, address.getId());
			} else {
				ps.setNull(4, BIGINT);
			}
			ps.executeUpdate();
			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {
					c.setId(rs.getLong(1));
				}
			}
		}
	}

	public void updateContact(Contact c) throws SQLException {

		Connection connection = PersistenceManager.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, c.getEmail());
			ps.setString(2, c.getFirstName());
			ps.setString(3, c.getLastName());
			Address address = c.getAddress();

			if (null != address) {
				if (null == address.getId()) {
					// daoAddress.create(address);
					// TODO créer l'adresse pour pouvoir l'associer au contact
					AddressDAO addressDAO = new AddressDAO();
					addressDAO.createAddress(address);
				}
				ps.setLong(4, address.getId());
			} else {
				ps.setNull(4, BIGINT);
			}
			ps.setLong(5, c.getId());
			ps.executeUpdate();
			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {
					c.setId(rs.getLong(1));
				}
			}
		}
	}

	public void deleteContact(Contact c) throws SQLException {

		Connection connection = PersistenceManager.getConnection();

		try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY, Statement.RETURN_GENERATED_KEYS)) {

			ps.setLong(1, c.getId());

			ps.executeUpdate();
		}
	}

	public Contact findById(Long id) {
		// TODO
		return null;
	}
}
