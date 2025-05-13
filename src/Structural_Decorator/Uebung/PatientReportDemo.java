package Structural_Decorator.Uebung;

public class PatientReportDemo {
    public static void main(String[] args) {
        PatientReport report = new BasicReport("Max Mustermann");

        report = new DiagnosisDecorator(report, "Hypertonie (Bluthochdruck)");
        report = new MedicationDecorator(report, "Ramipril 5mg täglich");
        report = new RecommendationDecorator(report, "Mehr Bewegung und salzarme Ernährung");

        System.out.println(report.generateReport());
    }
}
