public class AdministeredDrug {

	private Double dose;
	private Drug drug;

	public AdministeredDrug(Double dose, Drug drug) { this.dose = dose; this.drug = drug; }

	public Double getDose() { return dose; }
	public Drug getDrug() { return drug; }
}