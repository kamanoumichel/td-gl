import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Patient p = new Patient("Alice", "Dupont");
        p.getDiagnoses().add(new Diagnosis(new DiagnosisType("A01", "Example"), "Details", LocalDateTime.now()));

        Doctor d = new Doctor();
        // assign an action to doctor
        d.getAllowedActions().add(new Action("Patient examination", "Examine a patient", ActionType.PatientExamination));

        System.out.println("Patient: " + p.getFirstName() + " " + p.getLastName());
        System.out.println("Doctor allowed actions: " + d.getAllowedActions().size());
    }
}
