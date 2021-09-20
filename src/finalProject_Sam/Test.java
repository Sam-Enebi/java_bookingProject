//Name: Sam Enebi
//Student id: R00167276
//Class group: SD2-C
//Final project

package finalProject_Sam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Practice practice = new Practice();

		//Consultant 1
		Name consultant1Name = new Name();
		consultant1Name.setFirstName("Steven");
		consultant1Name.setLastName("Strange");

		Consultant consultant1 = new Consultant();
		consultant1.setId("Consultant1");
		consultant1.setName(consultant1Name);
		consultant1.setPhone("999-999-9999");
		consultant1.setExpertise("Labs");

		practice.addConsultant(consultant1);

		//Consultant 2
		Name consultant2Name = new Name();
		consultant2Name.setFirstName("Reed");
		consultant2Name.setLastName("Richards");

		Consultant consultant2 = new Consultant();
		consultant2.setId("Consultant2");
		consultant2.setName(consultant2Name);
		consultant2.setPhone("888-888-8888");
		consultant2.setExpertise("Pharmacy");

		practice.addConsultant(consultant2);

		//Consultant 3
		Name consultant3Name = new Name();
		consultant3Name.setFirstName("Bruce");
		consultant3Name.setLastName("Banner");

		Consultant consultant3 = new Consultant();
		consultant3.setId("Consultant3");
		consultant3.setName(consultant3Name);
		consultant3.setPhone("777-777-7777");
		consultant3.setExpertise("Medical");

		practice.addConsultant(consultant3);


		//Consultant1 Patient 1
		Name patient1Name = new Name();
		patient1Name.setFirstName("Donnie");
		patient1Name.setLastName("Darko");

		Patient patient1 = new Patient();
		patient1.setName(patient1Name);
		patient1.setId("patient1");
		patient1.setPhone("111-111-1111");
		patient1.setIllness("Flu");
		patient1.setSeverity(Severity.SEVERE);

		practice.findConsultant(consultant1Name).addPatient(patient1);

		//Consultant1 Patient 2
		Name patient2Name = new Name();
		patient2Name.setFirstName("Peter");
		patient2Name.setLastName("Parker");

		Patient patient2 = new Patient();
		patient2.setName(patient2Name);
		patient2.setId("patient2");
		patient2.setPhone("222-222-2222");
		patient2.setIllness("Cold");
		patient2.setSeverity(Severity.MILD);

		practice.findConsultant(consultant1Name).addPatient(patient2);

		//Consultant3 Patient 1
		Name patient3Name = new Name();
		patient3Name.setFirstName("Lois");
		patient3Name.setLastName("Lane");

		Patient patient3 = new Patient();
		patient3.setName(patient3Name);
		patient3.setId("patient3");
		patient3.setPhone("333-333-3333");
		patient3.setIllness("Covid");
		patient3.setSeverity(Severity.TOLERABLE);

		practice.findConsultant(consultant3Name).addPatient(patient3);

		//Add visits
		Visit patient1Visit1 = new Visit();
		patient1Visit1.setDateOfVisit(new Date());
		patient1Visit1.setNotes("Hello World!");
		Visit patient1Visit2 = new Visit();
		patient1Visit2.setDateOfVisit(new Date());
		patient1Visit2.setNotes("Feeling weak");

		Visit patient2Visit1 = new Visit();
		patient2Visit1.setDateOfVisit(new Date());
		patient2Visit1.setNotes("Nausea");

		practice.findConsultant(consultant1Name).addAPatientVisit(patient1Name, patient1Visit1);
		practice.findConsultant(consultant1Name).addAPatientVisit(patient1Name, patient1Visit2);
		practice.findConsultant(consultant1Name).addAPatientVisit(patient2Name, patient2Visit1);

		System.out.println(practice);

		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Welcome to the patient system!" + "\nSelect an option below using the number next to the command!");
		System.out.println("1) Record a Patient visit" + "\n2) Display all patients of a particular Consultant" +
				"\n3) Display all Consultants followed by their Patients followed by their visits" +
				"\n4) Load information from a text file" + "\n5) Quit");
		int command = scanner.nextInt();
		while (command != 5) {
			switch (command) {
				case 1: {
					System.out.println("Enter the consultant's first and last name separated by a comma>> ");
					scanner.nextLine();
					String consultant = scanner.nextLine();
					String[] splitC = consultant.split(",");
					if (splitC.length != 2) {
						System.out.println("The input provided does not match the correct format!\nPlease try again");
						break;
					}
					Name consultantName = new Name();
					consultantName.setFirstName(splitC[0].trim());
					consultantName.setLastName(splitC[1].trim());
					System.out.println("Enter the patient's first and last name separated by a comma>> ");
					String patient = scanner.nextLine();
					String[] splitP = patient.split(",");
					if (splitP.length != 2) {
						System.out.println("The input provided does not match the correct format!\nPlease try again");
						break;
					}
					Name patientName = new Name();
					patientName.setFirstName(splitP[0].trim());
					patientName.setLastName(splitP[1].trim());
					System.out.println("Add any notes: ");
					String notes = scanner.nextLine();
					Visit visit = new Visit();
					visit.setDateOfVisit(new Date());
					visit.setNotes(notes);
					practice.findConsultant(consultantName).addAPatientVisit(patientName, visit);
					break;
				}
				case 2: {
					System.out.println("Enter the consultant's first and last name separated by a comma>> ");
					scanner.nextLine();
					String consultant = scanner.nextLine();
					String[] split = consultant.split(",");
					if (split.length != 2) {
						System.out.println("The input provided does not match the correct format!\nPlease try again");
						break;
					}
					Name consultantName = new Name();
					consultantName.setFirstName(split[0].trim());
					consultantName.setLastName(split[1].trim());
					System.out.println(practice.findConsultant(consultantName));
					break;
				}
				case 3: {
					System.out.println(practice);
					break;
				}
				case 4: {
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\\\Users\\\\Lenovo\\\\Documents\\\\Eclipse\\\\finalProject_Sam\\\\practice.txt"));
						String line = bufferedReader.readLine();
						Consultant currentConsultant = null;
						Patient currentPatient = null;
						while (line != null) {
							String[] lineSplit = line.split(",");
							if (lineSplit.length == 6 && lineSplit[0].equals("Consultant") ||
									lineSplit.length == 7 && lineSplit[0].equals("Patient") ||
									lineSplit.length == 3 && lineSplit[0].equals("Visit")) {
								String objectToCreate = lineSplit[0];
								switch (objectToCreate) {
									case "Consultant":
										Consultant consultant = new Consultant();
										Name name = new Name();
										name.setLastName(lineSplit[1]);
										name.setFirstName(lineSplit[2]);
										consultant.setName(name);
										consultant.setId(lineSplit[3]);
										consultant.setPhone(lineSplit[4]);
										consultant.setExpertise(lineSplit[5]);
										practice.addConsultant(consultant);
										currentConsultant = consultant;
										break;
									case "Patient":
										Patient patient = new Patient();
										Name patientName = new Name();
										patientName.setLastName(lineSplit[1]);
										patientName.setFirstName(lineSplit[2]);
										patient.setName(patientName);
										patient.setId(lineSplit[3]);
										patient.setPhone(lineSplit[4]);
										patient.setIllness(lineSplit[5]);
										patient.setSeverity(Severity.values()[Integer.parseInt(lineSplit[6])]);
										practice.findConsultant(currentConsultant.getName()).addPatient(patient);
										currentPatient = patient;
										break;
									case "Visit":
										Visit visit = new Visit();
										visit.setDateOfVisit(new Date(lineSplit[1]));
										visit.setNotes(lineSplit[2]);
										practice.findConsultant(currentConsultant.getName())
												.addAPatientVisit(currentPatient.getName(), visit);
										break;
								}

								line = bufferedReader.readLine();
							} else {
								System.out.println("The file provided does not match the correct format!\nPlease try again");
								break;
							}
						}
						System.out.println("File successfully loaded!");
					} catch (IOException e) {
						System.out.println("An IO Exception Occurred. Please try again");
					}
					break;
				}
				case 5: {
					break;
				}
				default:
					System.out.println("Invalid input\nPlease try again");
					break;
			}
			System.out.println("\n");
			System.out.println("1) Record a Patient visit" + "\n2) Display all patients of a particular Consultant" +
					"\n3) Display all Consultants followed by their Patients followed by their visits" +
					"\n4) Load information from a text file" + "\n5) Quit");
			command = scanner.nextInt();
		}
	}
}
