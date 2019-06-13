package intro;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

//POJO
public class AppJPA implements Serializable {

	@Id
	private long id;
	private String email;
	private String firstName;
	private String lastName;

	public AppJPA() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
