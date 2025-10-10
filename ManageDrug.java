import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageDrug {
    private static  final String FICHIER = "drugs.dat";

    public static void  sauvegarder(List<Drug> liste){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHIER))) {
            oos.writeObject(liste);
            System.out.println(" Médicaments enregistrés dans " + FICHIER);
        } catch (IOException e) {
            System.out.println(" Erreur sauvegarde : " + e.getMessage());
        }
    }

    public static List<Drug> charger() {
        List<Drug> liste = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHIER))) {
            liste = (List<Drug>) ois.readObject();
            System.out.println("Médicaments chargés !");
        } catch (FileNotFoundException e) {
            System.out.println("Aucun fichier trouvé, nouvelle liste créée.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(" Erreur chargement : " + e.getMessage());
        }
        return liste;
    }

    public static void main(String[] args) {



          /* Scanner sc = new Scanner(System.in);
            List<Drug> drugs = ManageDrug.charger();
            List<AdministeredDrug> administeredList = ManageAdministeredDrugs.load();

            System.out.println("\n=== Liste des médicaments disponibles ===");
            for (int i = 0; i < drugs.size(); i++) {
                System.out.println((i+1) + ". " + drugs.get(i));
            }

            System.out.print("\nChoisir le numéro du médicament à administrer : ");
            int index = sc.nextInt();
            sc.nextLine(); // vider le buffer
            Drug selectedDrug = drugs.get(index - 1);

            System.out.print("Nom du patient : ");
            String patient = sc.nextLine();

            System.out.print("Dose : ");
            double dose = sc.nextDouble();
            sc.nextLine();

            System.out.print("Unité (mg, mL, etc.) : ");
            String unit = sc.nextLine();



            AdministeredDrug adm = new AdministeredDrug(dose,selectedDrug);
            administeredList.add(adm);

            ManageAdministeredDrugs.save(administeredList);

            System.out.println("\n📋 Liste des médicaments administrés :");
            for (AdministeredDrug a : administeredList) {
                System.out.println(a);
            }*/
    }


}






