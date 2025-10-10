public class Action {

	Employee AllowedActions;
	private String name;
	private String description;
	private ActionType type;

	public Action(String name, String description, ActionType patientExamination) {
		this.name = name;
		this.description = description;
		this.type = type;
	}

	public String getName() { return name; }
	public String getDescription() { return description; }
	public ActionType getType() { return type; }

}