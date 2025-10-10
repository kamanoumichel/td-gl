import java.util.*;
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


}