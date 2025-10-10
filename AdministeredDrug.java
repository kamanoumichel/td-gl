import java.io.Serializable;

public class AdministeredDrug implements Serializable {

	private Double dose;
	private Drug drug;

	public AdministeredDrug(Double dose, Drug drug) { this.dose = dose; this.drug = drug; }

	public Double getDose() { return dose; }
	public Drug getDrug() { return drug; }

	@Override
	public String toString() {
		return "Administration {" +
				"dose=" + dose +
				", médicament=" + (drug != null ? drug.getName() : "Inconnu") +
				'}';
	}
}