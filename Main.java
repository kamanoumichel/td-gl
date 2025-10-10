import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PatientService patientService = new PatientService();


        System.out.println("===============================");
        System.out.println("Sytème de gestion hospitalière");
        System.out.println("===============================");
        int choix=-1;
        System.out.println("Effectuer un choix");
        System.out.println("1-Creer un patient");
        System.out.println("2-Suivre un patient");
        System.out.println("3-Gérer rendez-vous");
        System.out.println("4-Créer un médicament");
        System.out.print("Veuillez effectué un choix : ");

        Scanner sc= new Scanner(System.in);

        choix= sc.nextInt();
        sc.nextLine(); // vider le buffer


        switch(choix) {
            case 1:
                System.out.println("\n=== Création d’un nouveau patient ===");

                System.out.print("Prénom : ");
                String firstName = sc.nextLine();

                System.out.print("Nom : ");
                String lastName = sc.nextLine();

                System.out.print("Numéro de sécurité sociale : ");
                String healthInsuranceNumber = sc.nextLine();

                System.out.print("Sexe (MALE/FEMALE) : ");
                String sexInput = sc.nextLine().toUpperCase();
                Sex sex = sexInput.equals("MALE") ? Sex.Male : Sex.Female;

                System.out.print("Adresse : ");
                String address = sc.nextLine();

                System.out.print("Statut du patient (ADMITTED/DISCHARGED/OBSERVATION) : ");
                String statusInput = sc.nextLine().toUpperCase();
                PatientStatus status;
                try {
                    status = PatientStatus.valueOf(statusInput);
                } catch (IllegalArgumentException e) {
                    status = null; // si saisie invalide
                }

                // Création du patient avec tous les attributs
                Patient p = new Patient(firstName, lastName, healthInsuranceNumber, sex, address, status);

                // Ajouter dans le fichier
                patientService.addPatient(p);

                System.out.println("\n✅ Patient ajouté avec succès !");

                // Afficher la liste complète des patients
                List<Patient> patients = patientService.listPatients();
                System.out.println("\n📋 Liste des patients :");
                for (Patient patient : patients) {
                    System.out.println("- " + patient.getFirstName() + " " + patient.getLastName() +
                            ", N°Sécu: " + patient.getHealthInsuranceNumber() +
                            ", Sexe: " + (patient.getSex() != null ? patient.getSex() : "N/A") +
                            ", Adresse: " + (patient.getAddress() != null ? patient.getAddress() : "N/A") +
                            ", Statut: " + (patient.getCurrentStatus() != null ? patient.getCurrentStatus() : "N/A"));
                }
                break;

            case 2:
                // code block
            case 3:
                // code block
            case 4:
                // code block
                break;
            default:
                // code block
        }
       // System.out.println(choix);
       // Patient p = new Patient("Alice", "Dupont");
        //p.getDiagnoses().add(new Diagnosis(new DiagnosisType("A01", "Example"), "Details", LocalDateTime.now()));

        //Doctor d = new Doctor();
        // assign an action to doctor
        //d.getAllowedActions().add(new Action("Patient examination", "Examine a patient", ActionType.PatientExamination));

        //System.out.println("Patient: " + p.getFirstName() + " " + p.getLastName());
        //System.out.println("Doctor allowed actions: " + d.getAllowedActions().size());
    }
}
