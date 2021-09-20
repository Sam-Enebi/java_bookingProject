//Name: Sam Enebi
//Student id: R00167276
//Class group: SD2-C
//Final project

package finalProject_Sam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Practice {
	private List<Consultant> consultants;

	public Practice() {
		this.consultants = new ArrayList<>();
	}

	public List<Consultant> getConsultants() {
		return consultants;
	}

	public void setConsultants(List<Consultant> consultants) {
		this.consultants = consultants;
	}

	public void addConsultant(Consultant consultant) {
		this.consultants.add(consultant);
	}

	public Consultant findConsultant(Name name) {
		for (Consultant consultant : consultants) {
			if (consultant.getName().equals(name)) {
				return consultant;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Consultants: " + consultants;
	}

	@Override
	public boolean equals(Object o) {
		Practice practice = (Practice) o;
		return Objects.equals(consultants, practice.consultants);
	}
}
