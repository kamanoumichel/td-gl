import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient {

	private PatientStatus currentStatus;
	private String firstName;
	private String lastName;
	private String healthinsuranceNumber;
	private LocalDate birthDate;
	private Sex sex;
	private String address;
	private Room room;

	private List<Diagnosis> diagnoses = new ArrayList<>();
	private List<PatientHistory> history = new ArrayList<>();

	public Patient() {}

	public Patient(String firstName, String lastName) {
		this.firstName = firstName; this.lastName = lastName;
	}

	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getHealthInsuranceNumber() { return healthinsuranceNumber; }
	public LocalDate getBirthDate() { return birthDate; }
	public Sex getSex() { return sex; }
	public String getAddress() { return address; }
	//public Room getRoom() { return room; }
	public PatientStatus getCurrentStatus() { return currentStatus; }
	public List<Diagnosis> getDiagnoses() { return diagnoses; }
	public List<PatientHistory> getHistory() { return history; }

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}


}