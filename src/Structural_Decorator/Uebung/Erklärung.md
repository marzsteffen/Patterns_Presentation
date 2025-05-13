
# Decorator Pattern in Java – Detaillierte Erklärung im eHealth-Kontext

Dieses Beispiel zeigt, wie das **Decorator Pattern** im eHealth-Bereich verwendet werden kann, um Patientenberichte dynamisch mit zusätzlichen Informationen wie Diagnosen, Medikation und Empfehlungen zu erweitern – ohne die ursprüngliche Klassenstruktur zu verändern.

---

## Übersicht: Struktur des Musters

| Komponente                | Beschreibung                                                                 |
|---------------------------|------------------------------------------------------------------------------|
| `PatientReport`           | Interface für alle Berichtskomponenten                                       |
| `BasicReport`             | Konkrete Implementierung eines einfachen Patientenberichts                   |
| `ReportDecorator`         | Abstrakter Dekorator, der das Interface implementiert und Berichte erweitert |
| `DiagnosisDecorator`      | Konkreter Dekorator für Diagnose-Informationen                               |
| `MedicationDecorator`     | Konkreter Dekorator für Medikationsinformationen                             |
| `RecommendationDecorator` | Konkreter Dekorator für Empfehlungen                                     |
| `PatientReportDemo`       | Testklasse zur Demonstration des Decorator-Einsatzes                         |

---

## 1. `PatientReport` – Das Interface

```java
public interface PatientReport {
    String generateReport();
}
```

### Erklärung
- Stellt die **gemeinsame Schnittstelle** für alle Berichtskomponenten bereit.
- Die Methode `generateReport()` liefert den Bericht als `String`.
- Dadurch können Basisbericht und Dekoratoren **austauschbar** verwendet werden.

---

## 2. `BasicReport` – Der Basisbericht

```java
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
```

### Erklärung
- Repräsentiert den **einfachsten Bericht**, der nur den Namen des Patienten enthält.
- Wird in der Praxis häufig als **Ausgangspunkt für Dekorationen** verwendet.

---

## 3. `ReportDecorator` – Der abstrakte Dekorator

```java
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
```

### Erklärung
- Diese Klasse ist **Basis für alle konkreten Dekoratoren**.
- Enthält ein Referenzobjekt vom Typ `PatientReport`.
- Gibt standardmäßig den Bericht des dekorierten Objekts weiter.
- Ermöglicht es, **funktionale Erweiterungen** ohne Änderung der Ursprungsstruktur durchzuführen.

---

## 4. `DiagnosisDecorator` – Hinzufügen einer Diagnose

```java
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
```

### Erklärung
- Fügt eine **Diagnosezeile** zum bestehenden Bericht hinzu.
- Kombiniert den vorherigen Bericht mit der neuen Information.

---

## 5. `MedicationDecorator` – Hinzufügen der Medikation

```java
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
```

### Erklärung
- Fügt eine Medikamenteninformation hinzu.
- Auch hier wird der Bericht erweitert, **ohne die bisherigen Klassen zu verändern**.

---

## 6. `RecommendationDecorator` – Empfehlungen hinzufügen

```java
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
```

### Erklärung
- Fügt Empfehlungen (z. B. Lebensstil, Therapieempfehlungen) zum Bericht hinzu.
- Wie bei allen Dekoratoren basiert es auf der Verkettung von Objekten.

---

## 7. `PatientReportDemo` – Anwendung und Test

```java
public class Main {
    public static void main(String[] args) {
        PatientReport report = new BasicReport("Max Mustermann");

        report = new DiagnosisDecorator(report, "Hypertonie (Bluthochdruck)");
        report = new MedicationDecorator(report, "Ramipril 5mg täglich");
        report = new RecommendationDecorator(report, "Mehr Bewegung und salzarme Ernährung");

        System.out.println(report.generateReport());
    }
}
```

### Erklärung
- Der Bericht wird **schrittweise erweitert**, indem er durch verschiedene Dekoratoren umschlossen wird.
- Die Reihenfolge der Dekorationen ist **flexibel und steuerbar**.
- **Vorteil:** Modularität und Offenheit für Erweiterungen (Open-Closed-Principle).

