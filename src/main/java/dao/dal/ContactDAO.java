package dao.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import dao.domain.Address;
import dao.domain.Contact;

//requetes SQL de la table contact dans cette classe
public class ContactDAO {

	private static final String INSERT_QUERY = "INSERT INTO contact (email, first_name, last_name, address_id) VALUES (?,?,?,?)";

	public void create(Contact c) throws SQLException {

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

				}
				ps.setLong(4, address.getId());
			}
			ps.executeUpdate();
//TODO récupérer la clé générée et l'affecter à objet contact via un resultSet
			// SELECT
		}
	}

	public void update(Contact c) {
		// TODO
	}

	public void delete(Contact c) {
		// TODO
	}

	public Contact findById(Long id) {
		// TODO
		return null;
	}
}
