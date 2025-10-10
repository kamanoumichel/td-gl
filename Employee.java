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


}