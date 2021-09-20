//Name: Sam Enebi
//Student id: R00167276
//Class group: SD2-C
//Final project

package finalProject_Sam;

import java.util.Date;
import java.util.Objects;

public class Visit {
	private Date dateOfVisit;
	private String notes;

	public Visit() {
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Date of Visit: " + dateOfVisit + ", Notes: " + notes;
	}

	@Override
	public boolean equals(Object o) {
		Visit visit = (Visit) o;
		return Objects.equals(dateOfVisit, visit.dateOfVisit) && Objects.equals(notes, visit.notes);
	}
}
