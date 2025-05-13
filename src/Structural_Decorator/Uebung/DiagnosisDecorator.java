package Structural_Decorator.Uebung;


public class DiagnosisDecorator extends ReportDecorator {
    private String diagnosis;

    public DiagnosisDecorator(PatientReport decoratedReport, String diagnosis) {
        super(decoratedReport);
        this.diagnosis = diagnosis;
    }

    @Override
    public String generateReport() {
        return super.generateReport() + "Diagnose: " + diagnosis + "\n";
    }
}
