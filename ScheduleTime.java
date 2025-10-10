import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleTime {

	private LocalDateTime from;
	private LocalDateTime to;
	private String note;
	private List<Employee> employees = new ArrayList<>();
	private Patient patient;
	private Room room;

	public ScheduleTime() {}

	public ScheduleTime(LocalDateTime from, LocalDateTime to, String note/*, Room room*/) {
		this.from = from; this.to = to; this.note = note; //this.room = room;
	}

	public LocalDateTime getFrom() { return from; }
	public LocalDateTime getTo() { return to; }
	public String getNote() { return note; }
	public List<Employee> getEmployees() { return employees; }
	public Patient getPatient() { return patient; }
	public Room getRoom() { return room; }

	@Override
	public String toString() {
		return "Schedule " + "from=" + from + ", to=" + to + ", note='" + note + '\'' +
				", employees=" + employees +
				", patient=" + patient +
				", room=" + room + '}';
	}
	public void prendre_un_rendez_vous(){

	}
}