package fspm.models.scenario;

import java.util.ArrayList;
import java.util.List;

public class Scenario {
    private String name;
    private List treatments;

    public Scenario() {
        treatments = new ArrayList();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTreatment(Treatment treatment) {
        treatments.add(treatment);
    }

    public List getTreatments() {
        return treatments;
    }
}
