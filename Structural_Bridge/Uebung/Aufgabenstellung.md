# Bridge Pattern Übung: Datenvisualisierung für medizinische Geräte

## Aufgabenstellung

Entwickeln Sie ein System zur Visualisierung von Daten verschiedener medizinischer Geräte unter Verwendung des Bridge Patterns. Das System soll es ermöglichen, Daten von unterschiedlichen Gerätetypen (z.B. EKG, Blutzuckermessgerät) mit verschiedenen Visualisierungsmethoden (z.B. Liniendiagramm, Tabelle) darzustellen.

**Ihre Aufgaben im Detail:**

1.  **Implementor-Seite (Visualisierungsmethoden):**
    * Definieren Sie ein Interface `DataVisualizer` (Implementor). Es sollte eine Methode deklarieren, die aufbereitete Daten entgegennimmt und darstellt, z.B. `void render(String formattedDataOutput)`. Der Einfachheit halber verwenden wir hier einen String für die aufbereiteten Daten; in einer realen Anwendung wäre das ein komplexeres Datenobjekt.
    * Erstellen Sie mindestens zwei konkrete Implementierungen dieses Interfaces:
        * `LineChartVisualizer`: Simuliert die Darstellung als Liniendiagramm (z.B. Konsolenausgabe: "LINE CHART: [formattedDataOutput]").
        * `TabularVisualizer`: Simuliert die Darstellung als Tabelle (z.B. Konsolenausgabe: "TABLE VIEW:\n[formattedDataOutput_zeilenweise_formatiert]").

2.  **Abstraction-Seite (Medizinische Geräte):**
    * Definieren Sie eine abstrakte Klasse `MedicalDevice` (Abstraction).
        * Diese Klasse soll eine Referenz auf ein `DataVisualizer`-Objekt halten (die "Brücke").
        * Sie soll einen Konstruktor haben, der einen `DataVisualizer` akzeptiert.
        * Deklarieren Sie eine Methode `public void displayDeviceData()`. Diese Methode ruft intern eine (ggf. abstrakte) Methode auf, um gerätespezifische Daten zu sammeln und zu formatieren, und übergibt diese dann an den `DataVisualizer`.
        * Deklarieren Sie eine abstrakte Methode `protected abstract String collectAndFormatData();`, die von den konkreten Geräten implementiert wird.

    * Erstellen Sie mindestens zwei konkrete Subklassen von `MedicalDevice` (RefinedAbstractions):
        * `EKGDevice`:
            * Sollte im Konstruktor den `DataVisualizer` an die Superklasse weitergeben.
            * Implementiert `collectAndFormatData()`, um typische EKG-Daten als String zu simulieren (z.B. "EKG-Daten: Zeit=0ms, Wert=0.1mV; Zeit=10ms, Wert=0.5mV; ...").
        * `GlucoseMeter`:
            * Sollte im Konstruktor den `DataVisualizer` an die Superklasse weitergeben.
            * Implementiert `collectAndFormatData()`, um typische Blutzuckerdaten als String zu simulieren (z.B. "Blutzucker: 10:00 Uhr - 95 mg/dL; 14:00 Uhr - 110 mg/dL").

3.  **Demo-Klasse:**
    * Erstellen Sie eine Klasse `MedicalDataVisualizationDemo`.
    * Demonstrieren Sie darin, wie Sie:
        * Ein `EKGDevice` erstellen, das seine Daten als Liniendiagramm darstellt.
        * Ein `EKGDevice` erstellen, das seine Daten als Tabelle darstellt.
        * Ein `GlucoseMeter` erstellen, das seine Daten als Tabelle darstellt.
        * Ein `GlucoseMeter` erstellen, das seine Daten als (vereinfachtes) Liniendiagramm darstellt.
        * Rufen Sie für jede Instanz die `displayDeviceData()`-Methode auf.

## Tipps

* Die Methode `displayDeviceData()` in der `MedicalDevice`-Klasse ist der Orchestrator: Sie ruft `collectAndFormatData()` auf, um die Daten zu bekommen, und gibt das Ergebnis dann an die `render()`-Methode des gehaltenen `DataVisualizer`-Objekts weiter.
* Konzentrieren Sie sich auf die Struktur und die Interaktion der Komponenten, nicht auf eine perfekte Simulation medizinischer Daten oder komplexer Visualisierungen. Einfache String-Manipulationen und Konsolenausgaben reichen aus.
* Überlegen Sie, wie einfach es wäre, einen `BloodPressureMonitor` oder einen `BarChartVisualizer` hinzuzufügen, ohne die bestehenden Klassen der jeweils anderen Hierarchie zu ändern.

Viel Erfolg!