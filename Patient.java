import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
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

	public Patient(String firstName, String lastName, String healthInsuranceNumber,
				   Sex sex, String address, PatientStatus currentStatus) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.healthInsuranceNumber = healthInsuranceNumber;
		this.sex = sex;
		this.address = address;
		this.currentStatus = currentStatus;
	}

	@Override
	public String toString() {
		return firstName + "," + lastName + "," + healthInsuranceNumber + "," +
				(sex != null ? sex.name() : "") + "," +
				(address != null ? address : "") + "," +
				(currentStatus != null ? currentStatus.name() : "");
	}

	public static Patient fromString(String line) {
		String[] parts = line.split(",", -1);
		if (parts.length >= 6) {
			String firstName = parts[0];
			String lastName = parts[1];
			String healthInsuranceNumber = parts[2];
			Sex sex = parts[3].isEmpty() ? null : Sex.valueOf(parts[3]);
			String address = parts[4];
			PatientStatus status = parts[5].isEmpty() ? null : PatientStatus.valueOf(parts[5]);

			return new Patient(firstName, lastName, healthInsuranceNumber, sex, address, status);
		}
		return null;
	}

	public static Patient findPatient(String firstName, String lastName) {
    try (BufferedReader reader = new BufferedReader(new FileReader("patients.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            Patient p = Patient.fromString(line);
            if (p != null && p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)) {
                return p;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}
}
