package Structural_Decorator.Uebung;


public class RecommendationDecorator extends ReportDecorator {
    private String recommendation;

    public RecommendationDecorator(PatientReport decoratedReport, String recommendation) {
        super(decoratedReport);
        this.recommendation = recommendation;
    }

    @Override
    public String generateReport() {
        return super.generateReport() + "Empfehlung: " + recommendation + "\n";
    }
}
