import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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

        switch(choix) {
            case 1:
                // code block
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
