package Structural_Decorator.Uebung;

public abstract class ReportDecorator implements PatientReport {
    protected PatientReport decoratedReport;

    public ReportDecorator(PatientReport decoratedReport) {
        this.decoratedReport = decoratedReport;
    }

    @Override
    public String generateReport() {
        return decoratedReport.generateReport();
    }
}
