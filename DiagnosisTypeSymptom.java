public class DiagnosisTypeSymptom {

	private Symptom symptoms;
	private DiagnosisType diagnosesTypes;
	private Occurrence occurrence;
	private Double occurencePercentage;

	public DiagnosisTypeSymptom(Occurrence occurrence, Double percentage) {
		this.occurrence = occurrence;
		this.occurencePercentage = percentage;
	}

	public Occurrence getOccurrence() { return occurrence; }
	public void setOccurrence(Occurrence occurrence) { this.occurrence = occurrence; }
	public Double getPercentage() { return occurencePercentage; }
	public void setPercentage(Double percentage) { this.occurencePercentage = percentage; }


}