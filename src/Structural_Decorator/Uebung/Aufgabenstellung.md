# Aufgabenstellung: Decorator Pattern im eHealth-Bereich


## Ziel
Implementieren Sie ein Softwaresystem in Java, das das **Decorator Pattern** verwendet, um Patientenberichte dynamisch mit Zusatzinformationen zu erweitern.

## Anforderungen

### 1. Basiskomponente
- Erstellen Sie ein Interface `PatientReport` mit der Methode `String generateReport()`.
- Implementieren Sie eine konkrete Klasse `BasicReport`, die einen einfachen Bericht mit dem Patientennamen erzeugt.

### 2. Dekoratoren
- Erstellen Sie eine abstrakte Klasse `ReportDecorator`, die das Interface `PatientReport` implementiert und ein `PatientReport`-Objekt enthält.
- Implementieren Sie folgende konkrete Dekorator-Klassen:
    - `DiagnosisDecorator`: Fügt dem Bericht eine Diagnose hinzu.
    - `MedicationDecorator`: Fügt dem Bericht eine Medikation hinzu.
    - `RecommendationDecorator`: Fügt dem Bericht eine Empfehlung hinzu.

### 3. Hauptprogramm
- Implementieren Sie eine `Main`-Klasse mit `main()`-Methode.
- Erzeugen Sie ein `PatientReport`-Objekt mit einem `BasicReport`.
- Dekorieren Sie den Bericht mit mindestens zwei zusätzlichen Informationen (z. B. Diagnose + Medikation).
- Geben Sie den vollständigen Bericht auf der Konsole aus.

## Beispielausgabe

- Patientenbericht für: Max Mustermann
- Diagnose: Hypertonie (Bluthochdruck)
- Medikation: Ramipril 5mg täglich
- Empfehlung: Mehr Bewegung und salzarme Ernährung