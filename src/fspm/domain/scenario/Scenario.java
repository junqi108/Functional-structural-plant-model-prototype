package fspm.domain.scenario;

import java.util.ArrayList;
import java.util.List;

public class Scenario {
    private String name;
    private List treatments;

    public Scenario() {
        treatments = new ArrayList();
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        String outString = String.format("Scenario name: %s", name);

        for (int i = 0; i < treatments.size(); i++) {
            Treatment treatment = (Treatment) treatments.get(i);
            outString += "\n" + treatment;
        }
        return outString;
    }
}
