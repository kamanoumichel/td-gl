import java.io.*;
import java.util.*;

public class ManageAdministeredDrugs {
    private static final String FILE_NAME = "administered_drugs.dat";

    public static void save(List<AdministeredDrug> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(list);
            System.out.println("Médicaments administrés enregistrés avec succès !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<AdministeredDrug> load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<AdministeredDrug>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
