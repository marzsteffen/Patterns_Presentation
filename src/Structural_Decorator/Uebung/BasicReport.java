package Structural_Decorator.Uebung;

// BasicReport.java
public class BasicReport implements PatientReport {
    private String patientName;

    public BasicReport(String patientName) {
        this.patientName = patientName;
    }

    @Override
    public String generateReport() {
        return "Patientenbericht für: " + patientName + "\n";
    }
}
