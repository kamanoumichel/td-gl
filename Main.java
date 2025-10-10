import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<ScheduleTime> scheduleList = new ArrayList<>();

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
                Scanner scanner = new Scanner(System.in);

    System.out.print("Entrez le prénom du patient : ");
    String firstName1 = scanner.nextLine();

    System.out.print("Entrez le nom du patient : ");
    String lastName1 = scanner.nextLine();

    Patient patient = Patient.findPatient(firstName1, lastName1);
    if (patient == null) {
        System.out.println("Patient non trouvé.");
        return;
    }

    System.out.print("Entrez le code de l'employé : ");
    String empCode = scanner.nextLine();

    Employee emp = Employee.findEmployee(empCode, "employee.txt");
    if (emp == null) {
        System.out.println("Employé non trouvé.");
        return;
    }

    System.out.print("Entrez le statut du patient (Away, Hospitalized, Operated, IntensiveCare, Unrecorded) : ");
    String statusStr = scanner.nextLine();
    PatientStatus status2 = PatientStatus.valueOf(statusStr);

    System.out.print("Entrez une note : ");
    String note = scanner.nextLine();

    PatientHistory history = new PatientHistory(LocalDateTime.now(), status2, emp, note);
    PatientHistory.saveToFile(patient, history);

    System.out.println("Historique enregistré !");
    System.out.println("Affichage de l'historique du patient :");
    PatientHistory.printHistoryForPatient(firstName1, lastName1);
    break;
            case 3:
                // Exemple de données
                Employee e1 = new Employee("E001", "Marie", "Dupont");
                Employee e2 = new Employee("E002", "Paul", "Durand");
                Patient p1 = new Patient("Alice", "Martin","NJHY15", Sex.Female, "17 Rue Calais", PatientStatus.Hospitalized);
                Patient p2 = new Patient("Jean", "Bernard","NJHY16",Sex.Male, "17 Rue Calais", PatientStatus.Away);

                // Création des rendez-vous
                addAppointment(LocalDateTime.of(2025, 10, 10, 9, 0),
                        LocalDateTime.of(2025, 10, 10, 10, 0),
                        "Consultation générale",
                        List.of(e1),
                        p1);

                addAppointment(LocalDateTime.of(2025, 10, 10, 9, 30),
                        LocalDateTime.of(2025, 10, 10, 10, 30),
                        "Suivi postopératoire",
                        List.of(e1),
                        p2);  // ⚠️ Conflit avec le premier

                addAppointment(LocalDateTime.of(2025, 10, 10, 10, 30),
                        LocalDateTime.of(2025, 10, 10, 11, 0),
                        "Consultation pédiatrique",
                        List.of(e2),
                        p1);

                // Affichage des rendez-vous valides
                System.out.println("\n--- Liste des rendez-vous ---");
                scheduleList.forEach(System.out::println);
                break;
            case 4:
                Scanner sec = new Scanner(System.in);
                List<Drug> list = ManageDrug.charger();

                System.out.println("\n=== Add a new drug ===");
                System.out.print("Code: ");
                String code = sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Form: ");
                String form = sc.nextLine();

                System.out.print("Description: ");
                String desc = sc.nextLine();

                System.out.print("Route (administration path): ");
                String route = sc.nextLine();

                Drug d = new Drug(code, name, form, desc, route);
                list.add(d);

                ManageDrug.sauvegarder(list);

                System.out.println("\n📋 List of registered drugs:");
                for (Drug drug : list) {
                    System.out.println(drug);
                }
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

    public static void addAppointment(LocalDateTime from, LocalDateTime to, String note,
                                      List<Employee> employees, Patient patient) {

        ScheduleTime newSchedule = new ScheduleTime(from, to, note, employees, patient);

        // Vérification de chevauchement
        for (ScheduleTime existing : scheduleList) {
            for (Employee emp : employees) {
                if (existing.getEmployees().contains(emp) && existing.overlaps(newSchedule)) {
                    System.out.println("⚠️ Conflit : " + emp.getFullName() +
                            " a déjà un rendez-vous à cette heure !");
                    return;
                }
            }
        }

        scheduleList.add(newSchedule);
        System.out.println("✅ Rendez-vous ajouté : " + newSchedule);
    }
}
