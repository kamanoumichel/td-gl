import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Drug implements Serializable {

	private String code;
	private String name;
	private String form;
	private String description;
	private String route;
	//private List<AdministeredDrug> administrations;


	public Drug(String code, String name, String form, String description, String route) {
		this.code = code;
		this.name = name;
		this.form = form;
		this.description = description;
		this.route = route;
		//this.administrations = new ArrayList<>();
	}

	/*public void ajouterAdmistration(AdministeredDrug adm) {
		administrations.add(adm);
	}

	public List<AdministeredDrug> getAdmistrations() {
		return administrations;
	}*/

	public String getCode() {
		return code;
	}

	public String getForm() {
		return form;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getRoute() {
		return route;
	}

	/*public List<AdministeredDrug> getAdministrations() {
		return administrations;
	}*/


	@Override
	public String toString() {
		return "Médicament {" +
				"code='" + code + '\'' +
				", nom='" + name + '\'' +
				", forme='" + form + '\'' +
				", description='" + description + '\'' +
				", route='" + route + '\'' +
				'}';
	}
}