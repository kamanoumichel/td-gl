import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class PatientHistory {

	private Collection<AdministeredDrug> administeredDrugs;
	private LocalDateTime changeDate;
	private PatientStatus status;
	private Room room;
	private Employee visitedBy;
	private String note;


	public PatientHistory() {}

	public PatientHistory(LocalDateTime changeDate, PatientStatus status, /*Room room,*/ Employee visitedBy, String note) {
		this.changeDate = changeDate;
		this.status = status;
		//  this.room = room;
		this.visitedBy = visitedBy;
		this.note = note;
	}

	public LocalDateTime getChangeDate() { return changeDate; }
	public PatientStatus getStatus() { return status; }
	//public Room getRoom() { return room; }
	public Employee getVisitedBy() { return visitedBy; }
	public String getNote() { return note; }


	
public static void saveToFile(Patient patient, PatientHistory history) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("historique.txt", true))) {
        writer.write(patient.getFirstName() + "," + patient.getLastName() + "," +
                     history.getChangeDate() + "," + history.getStatus() + "," +
                     (history.getVisitedBy() != null ? history.getVisitedBy().getFirstName() + " " + history.getVisitedBy().getLastName() : "N/A") +
                     "," + history.getNote());
        writer.newLine();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void printHistoryForPatient(String firstName, String lastName) {
    try (BufferedReader reader = new BufferedReader(new FileReader("historique.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",", 6);
            if (parts.length >= 6 && parts[0].equals(firstName) && parts[1].equals(lastName)) {
                System.out.println("Date: " + parts[2] +
                                   ", Status: " + parts[3] +
                                   ", Visited by: " + parts[4] +
                                   ", Note: " + parts[5]);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Entrez le prénom du patient : ");
    String firstName = scanner.nextLine();

    System.out.print("Entrez le nom du patient : ");
    String lastName = scanner.nextLine();

    Patient patient = Patient.findPatient(firstName, lastName);
    if (patient == null) {
        System.out.println("Patient non trouvé.");
        return;
    }

    System.out.print("Entrez le code de l'employé : ");
    String empCode = scanner.nextLine();

    Employee emp = Employee.findEmployee(empCode, "employee.txt");
    if (emp == null) {
        System.out.println("Employé non trouvé.");
        return;
    }

    System.out.print("Entrez le statut du patient (Away, Hospitalized, Operated, IntensiveCare, Unrecorded) : ");
    String statusStr = scanner.nextLine();
    PatientStatus status = PatientStatus.valueOf(statusStr);

    System.out.print("Entrez une note : ");
    String note = scanner.nextLine();

    PatientHistory history = new PatientHistory(LocalDateTime.now(), status, emp, note);
    saveToFile(patient, history);

    System.out.println("Historique enregistré !");
    System.out.println("Affichage de l'historique du patient :");
    printHistoryForPatient(firstName, lastName);
}

}