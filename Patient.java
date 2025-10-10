import java.util.ArrayList;
import java.util.List;

public class Patient {

	private PatientStatus currentStatus;
	private String firstName;
	private String lastName;
	private String healthInsuranceNumber;
	private Sex sex;
	private String address;
	private Room room;

	private List<Diagnosis> diagnoses = new ArrayList<>();
	private List<PatientHistory> history = new ArrayList<>();

	public Patient() {}

	public Patient(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getHealthInsuranceNumber() { return healthInsuranceNumber; }
	public Sex getSex() { return sex; }
	public String getAddress() { return address; }
	public PatientStatus getCurrentStatus() { return currentStatus; }
	public List<Diagnosis> getDiagnoses() { return diagnoses; }
	public List<PatientHistory> getHistory() { return history; }

	// === Fichier texte ===
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	public static Patient fromString(String line) {
		line = line.trim();
		if (!line.isEmpty()) {
			String[] parts = line.split(" ", 2);
			String firstName = parts[0];
			String lastName = parts.length > 1 ? parts[1] : "";
			return new Patient(firstName, lastName);
		}
		return null;
	}
}
