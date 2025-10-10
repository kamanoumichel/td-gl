import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PatientService {

    private static final String FILE_PATH = "patients.txt";

    // ➕ Ajouter un patient dans le fichier
    public void addPatient(Patient patient) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(patient.toString());
            writer.newLine();
            System.out.println("✅ Patient ajouté : " + patient.getFirstName() + " " + patient.getLastName());
        } catch (IOException e) {
            System.err.println("❌ Erreur lors de l’écriture du patient dans le fichier : " + e.getMessage());
        }
    }

    public List<Patient> listPatients() {
        List<Patient> patients = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("⚠️ Aucun patient enregistré.");
            return patients;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Patient patient = Patient.fromString(line);
                if (patient != null) {
                    patients.add(patient);
                }
            }
        } catch (IOException e) {
            System.err.println("❌ Erreur lors de la lecture des patients : " + e.getMessage());
        }

        return patients;
    }
}
