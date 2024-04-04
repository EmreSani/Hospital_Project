package Hospital_Project;

public class Case {
    private String actualCase;
    private boolean isEmergency;

    public Case() {
    }

    public Case(String actualCase, boolean isEmergency) {
        this.actualCase = actualCase;
        this.isEmergency = isEmergency;
    }

    @Override
    public String toString() {
        return "Hastalık Durumunuz:'" + actualCase + '\'' +
                ", aciliyet=" + isEmergency;
    }

    public String getActualCase() {
        return actualCase;
    }

    public void setActualCase(String actualCase) {
        this.actualCase = actualCase;
    }

    public boolean isEmergency() {
        return isEmergency;
    }

    public void setEmergency(boolean emergency) {
        this.isEmergency = emergency;
    }
}
