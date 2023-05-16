package fspm.domain.scenario;

import java.util.List;

public class Treatment {
    private String name;
    private int startYear;
    private int endYear;
    private List configs;

    public Treatment() {

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public void setConfigs(List configs) {
        this.configs = configs;
    }

    @Override
    public String toString() {
        return String.format("Treatment name: %s, [%d to %d]", name, startYear, endYear);
    }
}
