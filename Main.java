import java.time.LocalDateTime;
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

                Patient p = new Patient(firstName, lastName);

                patientService.addPatient(p);

                System.out.println("\n✅ Patient ajouté avec succès !");
                patientService.listPatients();
                break;
            case 2:
                // code block
            case 3:
                // Exemple de données
                Employee e1 = new Employee("E001", "Marie", "Dupont");
                Employee e2 = new Employee("E002", "Paul", "Durand");
                Patient p1 = new Patient("Alice", "Martin");
                Patient p2 = new Patient("Jean", "Bernard");

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
