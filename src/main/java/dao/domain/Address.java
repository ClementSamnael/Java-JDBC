package dao.domain;

import java.util.Set;

public class Address {

	private long id;
	private String details;
	private Set<Contact> contacts;

	// -----------Constructor----------------\\
	public Address(long id, String details) {
		this.id = id;
		this.details = details;
	}

	// -----------GETTER----------------\\
	public long getId() {
		return id;
	}

	public String getDetails() {
		return details;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	// -----------SETTER----------------\\
	public void setId(long id) {
		this.id = id;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	// -----------@Override----------------\\
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [id=");
		builder.append(id);
		builder.append(", details=");
		builder.append(details);
		builder.append("]");
		return builder.toString();
	}

}
