import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Employee {

	private String personalNumber;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private List<Action> allowedActions = new ArrayList<>();

	public Employee() {}

	public Employee(String personalNumber, String firstName, String lastName) {
		this.personalNumber = personalNumber; this.firstName = firstName; this.lastName = lastName;
	}

	public String getPersonalNumber() { return personalNumber; }
	//public String getTitle() { return title; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getPhoneNumber() { return phoneNumber; }
	public List<Action> getAllowedActions() { return allowedActions; }

	public String getFullName() {
		return firstName + " " + lastName;
	}

	@Override
	public String toString() {
		return getFullName();
	}


	public static Employee findEmployee(String code, String filename) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 3 && parts[0].equals(code)) {
                return new Employee(parts[0], parts[1], parts[2]);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}
}