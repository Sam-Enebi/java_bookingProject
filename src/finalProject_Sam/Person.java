//Name: Sam Enebi
//Student id: R00167276
//Class group: SD2-C
//Final project

package finalProject_Sam;

import java.util.Objects;

public class Person {
	private Name name;
	private String id;
	private String phone;

	public Person() {
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public boolean equals(Object o) {
		Person person = (Person) o;
		return Objects.equals(name, person.name) && Objects.equals(id, person.id) &&
				Objects.equals(phone, person.phone);
	}

	@Override
	public String toString() {
		return "Person{" + "name=" + name + ", id='" + id + '\'' + ", phone='" + phone + '\'' + '}';
	}
}
