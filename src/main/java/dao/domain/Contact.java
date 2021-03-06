package dao.domain;

import java.util.Objects;

public class Contact {

	private long id;
	private String email;
	private String firstName;
	private String lastName;
	private Address address;

	// -----------Constructor-------------------//
	public Contact() {
	}

	public Contact(long id, String email, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// -----------GETTER-------------------//
	public long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Address getAddress() {
		return address;
	}

	// ------------SETTER-----------------//
	public void setId(long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(Address address) {
		if (this.address != null) {
			this.address.getContacts().remove(this);
		}
		this.address = address;
		if (this.address != null) {
			this.address.getContacts().add(this);
		}
	}

	public void addContact(Contact c) {

	}

	// ------------@Override-----------------//

	@Override
	public int hashCode() {
		return Objects.hash(address, email, firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof Contact))
			return false;

		Contact other = (Contact) obj;
		return Objects.equals(email, other.email);

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contact [id=");
		builder.append(id);
		builder.append(", email=");
		builder.append(email);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}

}
