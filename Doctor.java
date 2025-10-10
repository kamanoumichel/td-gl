import java.util.ArrayList;
import java.util.List;

public class Doctor extends Employee {
    private List<Specialization> specializations = new ArrayList<>();

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }
}