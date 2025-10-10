import java.util.ArrayList;
import java.util.List;

public class PatientService {

    private List<Patient> patients = new ArrayList<>();

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("✅ Patient ajouté : " + patient);
    }

    public void listPatients() {
        if (patients.isEmpty()) {
            System.out.println("⚠️ Aucun patient enregistré.");
        } else {
            System.out.println("\n=== Liste des patients enregistrés ===");
            for (int i = 0; i < patients.size(); i++) {
                Patient p = patients.get(i);
                System.out.println((i + 1) + ". " + p.getFirstName() + " " + p.getLastName());
            }
        }
    }

    public List<Patient> getPatients() {
        return patients;
    }
}
