//Name: Sam Enebi
//Student id: R00167276
//Class group: SD2-C
//Final project

package finalProject_Sam;

import java.util.Objects;

public class Name {
	private String firstName;
	private String lastName;

	public Name() {
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

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	@Override
	public boolean equals(Object o) {
		Name name = (Name) o;
		return Objects.equals(firstName, name.firstName) && Objects.equals(lastName, name.lastName);
	}
}
