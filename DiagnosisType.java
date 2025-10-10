import java.util.ArrayList;
import java.util.List;

public class DiagnosisType {

	private List<DiagnosisTypeSymptom> symptoms = new ArrayList<>();

	private String code;
	private String description;


	public DiagnosisType() {}

	public DiagnosisType(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() { return code; }
	public void setCode(String code) { this.code = code; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public List<DiagnosisTypeSymptom> getSymptoms() { return symptoms; }

}