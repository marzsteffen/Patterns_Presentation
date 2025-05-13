package Structural_Decorator.Uebung;


public class MedicationDecorator extends ReportDecorator {
    private String medication;

    public MedicationDecorator(PatientReport decoratedReport, String medication) {
        super(decoratedReport);
        this.medication = medication;
    }

    @Override
    public String generateReport() {
        return super.generateReport() + "Medikation: " + medication + "\n";
    }
}
