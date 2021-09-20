//Name: Sam Enebi
//Student id: R00167276
//Class group: SD2-C
//Final project

package finalProject_Sam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Patient extends Person {
	private List<Visit> visits;
	private String illness;
	private Severity severity;

	public Patient() {
		this.visits = new ArrayList<>();
	}

	public List<Visit> getVisits() {
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public void addAVisit(Visit visit) {
		this.visits.add(visit);
	}

	@Override
	public String toString() {
		return "Name: " + getName() + ", Illness: " + illness + ", Severity: " + severity + "\n\tVisits: " + visits + "\n\t";
	}

	@Override
	public boolean equals(Object o) {
		Patient patient = (Patient) o;
		return Objects.equals(visits, patient.visits) && Objects.equals(illness, patient.illness) &&
				severity == patient.severity;
	}
}
