import java.util.*;
import java.time.LocalDateTime;

public class Diagnosis {

	private Collection<Symptom> syptoms;
	private DiagnosisType type;
	private String details;
	private LocalDateTime diagnosisDate;

	public Diagnosis() {}

	public Diagnosis(DiagnosisType type, String details, LocalDateTime diagnosisDate) {
		this.type = type;
		this.details = details;
		this.diagnosisDate = diagnosisDate;
	}

	public DiagnosisType getType() { return type; }
	public void setType(DiagnosisType type) { this.type = type; }
	public String getDetails() { return details; }
	public void setDetails(String details) { this.details = details; }
	public LocalDateTime getDiagnosisDate() { return diagnosisDate; }
	public void setDiagnosisDate(LocalDateTime diagnosisDate) { this.diagnosisDate = diagnosisDate; }

}