//Name: Sam Enebi
//Student id: R00167276
//Class group: SD2-C
//Final project

package finalProject_Sam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Consultant extends Person {
	private List<Patient> patients;
	private String expertise;

	public Consultant() {
		this.patients = new ArrayList<>();
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public void addPatient(Patient patient) {
		this.patients.add(patient);
	}

	public void addAPatientVisit(Name name, Visit visit) {
		for (Patient patient : patients) {
			if (patient.getName().equals(name)) {
				patient.addAVisit(visit);
				return;
			}
		}
	}

	@Override
	public String toString() {
		return "Consultant: " + getName() + ", Expertise: " + expertise + "\n\tPatients: " + patients;
	}

	@Override
	public boolean equals(Object o) {
		Consultant that = (Consultant) o;
		return Objects.equals(patients, that.patients) && Objects.equals(expertise, that.expertise);
	}
}
